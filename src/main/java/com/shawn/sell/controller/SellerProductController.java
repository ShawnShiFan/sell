package com.shawn.sell.controller;

import com.shawn.sell.dataobject.ProductCategory;
import com.shawn.sell.dataobject.ProductInfo;
import com.shawn.sell.dto.OrderDTO;
import com.shawn.sell.exception.SellException;
import com.shawn.sell.form.ProductForm;
import com.shawn.sell.service.CategoryService;
import com.shawn.sell.service.ProductService;
import com.shawn.sell.utils.KeyUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 卖家端商品
 * @Author: Shawn
 * @Date: 2019/4/8 10:39
 * @Version 1.0
 */

@Controller
@RequestMapping("seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService  categoryService;

    /**
     * 商品列表
     * @param page 第几页，从第一页开始
     * @param size 一页有多少条数据
     * @param map
     * @return
     * */


    @GetMapping("/list")
    public ModelAndView list(@RequestParam(required = false,value="page",defaultValue = "1") Integer page,
                             @RequestParam(required = false,value = "size",defaultValue = "6") Integer size,
                             Map<String,Object> map){

        PageRequest request =PageRequest.of(page-1,size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size", size);

        return new ModelAndView("product/list" , map);

    }

    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId" ,required = false) String productId,
                      Map<String, Object> map){

        if (!StringUtils.isEmpty(productId)){
          ProductInfo productInfo = productService.findById(productId);
          map.put("productInfo",productInfo);
        }
        //查询所有的类目
        List<ProductCategory> categoryList =categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("product/index",map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView  save(@Valid ProductForm form,
                              BindingResult bindingResult,
                              Map<String,Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            //如果productId为空，说明是新增
            if (!StringUtils.isEmpty(form.getProductId())){
                productInfo = productService.findById(form.getProductId());
                form.setCreateTime(productInfo.getCreateTime());
                form.setUpdateTime(new Date());
            }else {
                form.setProductId(KeyUtil.genUniqueKey());
                form.setCreateTime(new Date());
                form.setUpdateTime(new Date());
            }


        BeanUtils.copyProperties(form,productInfo);
        productService.save(productInfo);
      }catch (SellException e){
          map.put("msg",e.getMessage());
          map.put("url","/sell/seller/product/index");
          return new ModelAndView("common/error",map);
      }
        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success",map);
    }

}
