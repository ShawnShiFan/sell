package com.shawn.sell.controller;

import com.shawn.sell.VO.ProductInfoVO;
import com.shawn.sell.VO.ProductVO;
import com.shawn.sell.VO.ResultVO;
import com.shawn.sell.dataobject.ProductCategory;
import com.shawn.sell.dataobject.ProductInfo;
import com.shawn.sell.service.CategoryService;
import com.shawn.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**买家商品
 * @Author: Shawn
 * @Date: 2019/2/11 15:14
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有上架商品
       List<ProductInfo> productInfoList = productService.findUpAll();

       //2.查询类目（一次性查询）
        //List<Integer> categoryTypeList = new ArrayList<>()
        //实现遍历所有商品类目
        //传统方法
       /* for(ProductInfo productInfo: productInfoList){
                categoryTypeList.add( productInfo.getCategoryType()) ;
        }*/
        //精简方法（java8 ， lambda）
       List<Integer> categoryTypeList =   productInfoList.stream()
               .map(e -> e.getCategoryType())
               .collect(Collectors.toList());
        List<ProductCategory> productCategoryList =  categoryService.findByCategoryTypeIn(categoryTypeList);


        //3.数据拼装
         List<ProductVO> productVOList = new ArrayList<>();
           //首先遍历类目
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }



        ResultVO resultVO = new ResultVO();

        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productVOList);

        return  resultVO;
    }
}
