package com.jalasoft.sfdc.api.apiClass;

import com.jalasoft.sfdc.api.APIManager;
import com.jalasoft.sfdc.entities.Product;

import java.util.HashMap;
import java.util.Map;

import static com.jalasoft.sfdc.constants.SFDCConstants.*;


public class APIProduct extends APIBase{
    private final Product product;
    private Product productApi;

    /**
     * constructor APIProduct.
     * @param product
     */
    public APIProduct(Product product) {
        this.product = product;
        this.productApi = new Product();
        fieldsMap = covertEntityToMap();
        apiSObjectName = PRODUCT;
    }

    /**
     * convert json to map
     *
     * @return
     */
    @Override
    protected Map<String, Object> covertEntityToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(PRODUCT_NAME, product.getProductName());
        map.put(PRODUCT_CODE, product.getProductCode());
        map.put(PRODUCT_DESCRIPTION, product.getProductDescription());
        map.put(PRODUCT_FAMILY, product.getProductFamily());
        map.put(PRODUCT_ACTIVE, product.getActive());
        return map;
    }

    @Override
    protected void setAPIObjectId() {
        product.setId(response.jsonPath().get(ID).toString());
    }

    @Override
    protected String getAPIObjectId() {
        return product.getId();
    }

    /**
     * get values of json
     * @return
     */
    public Product getProductValuesByAPI() {
        response = APIManager.getInstance().get("/sobjects/Product2/" + product.getId());
        productApi.setProductName(response.jsonPath().get(PRODUCT_NAME).toString());
        productApi.setProductCode(response.jsonPath().get(PRODUCT_CODE).toString());
        productApi.setProductDescription(response.jsonPath().get(PRODUCT_DESCRIPTION).toString());
        productApi.setProductFamily(response.jsonPath().get(PRODUCT_FAMILY).toString());
        return productApi;
    }
}
