package com.project.Shop.config;

import com.project.Shop.entity.DiscountCode;
import com.project.Shop.repository.DiscountCodeRepository;
import com.project.Shop.service.DiscountCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;



//kiem tra va cap nhap ma giam gia
@Component
public class ScheduledApp {
    @Autowired
    private DiscountCodeService discountCodeService;

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    @Scheduled(fixedRate = 60*60*100) // 1 gio
    public void checkAndSetExpiredStatus() {
        Date currentDate = new Date();
        List<DiscountCode> expiredDiscountCodes = null;
        if(!expiredDiscountCodes.isEmpty()) {
            for (DiscountCode discountCode : expiredDiscountCodes) {
                if (currentDate.after(discountCode.getEndDate())) {
                    discountCode.setStatus(3);
                    discountCodeRepository.save(discountCode);
                }
            }
        }

    }
}
