package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.Product;
import com.demo.Repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
//	public  products addProductImage(byte[] imageBytes, String id) {
//		int idInt=Integer.parseInt(id);
//		products product=productRepo.findById(idInt).orElse(new products());
//		 product.setImage(imageBytes);
//		 System.out.println("images executed");
//		return productRepo.save(product);
//	}
	
	
//	public Product updateProduct(Product product) {
//		Product existingProduct= productRepo.findById(product.getId()).orElse(new Product());
//		existingProduct.setProductName(product.getProductName());
////		existingProduct.setImage(product.getImage());
//		existingProduct.setDescription(product.getDescription());
//		existingProduct.setPrice(product.getPrice());
//		existingProduct.setColor(product.getColor());
//		return productRepo.save(existingProduct);
//	}
	
	public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setBrand(updatedProduct.getBrand());
            
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return true;
        }
        return false;
    }
}







