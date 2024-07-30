package com.project.Shop.service.serviceImpl;

import com.project.Shop.entity.Image;
import com.project.Shop.entity.Product;
import com.project.Shop.repository.ImageRepository;
import com.project.Shop.repository.ProductRepository;
import com.project.Shop.service.ImageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Image> getAllImagesByProductId(Long productId)  {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            return imageRepository.findAllByProduct(product.get());
        }
        return null;
    }

    @Override
    public void removeImageByIds(List<Long> ids) {
        imageRepository.deleteAllById(ids);
    }
//    @Override
//    public List<Image> saveALL(List<Image> images) {
//        return imageRepository.saveAll(images);
//    }
//
//    @Override
//    public Image save(Image images) {
//        return imageRepository.save(images);
//    }
//
//    @Override
//    public Image findByID(Long id) {
//        return imageRepository.findImageById(id);
//    }
//    @Override
//    public void delete(Long id) {
//        imageRepository.deleteById(id);
//    }
}
