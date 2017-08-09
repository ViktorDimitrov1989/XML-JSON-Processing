package app.services.impl;

import app.dto.add.AddSaleDto;
import app.dto.views.SaleWithDiscount;
import app.models.Part;
import app.models.Sale;
import app.repositories.SaleRepository;
import app.services.SalesService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SaleServiceImpl implements SalesService{
    private SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    @Override
    public void saveSale(AddSaleDto sale) {
        Sale s = DtoMappingUtil.convert(sale, Sale.class);
        this.saleRepository.saveAndFlush(s);
    }

    @Override
    public List<SaleWithDiscount> getSalesWithAppliedDiscount() {
        List<Sale> sales = this.saleRepository.findAll();

        List<SaleWithDiscount> resSales = DtoMappingUtil.convert(sales, SaleWithDiscount.class);


        String debug = "";

        for (int i = 0; i < resSales.size(); i++) {
            SaleWithDiscount sale = resSales.get(i);
            Sale originalSale = sales.get(i);

            double price = originalSale.getCar().getParts().stream().mapToDouble(Part::getPrice).sum();
            sale.setCustomerPrice(price);

            double discountPercentage = originalSale.getDiscountPercentage();

            long timeDiff = Math.abs(sale.getCustomer().getBirthDate().getTime() - new Date().getTime());
            double years = Math.floor(TimeUnit.MILLISECONDS.toDays(timeDiff) / 365);

            if(years <= 20){
                discountPercentage += 0.5;
            }
            sale.setCustomerDiscountPercentage(discountPercentage);
            double priceWithDiscount = price - (price * discountPercentage);

            sale.setCustomerPriceWithDiscount(priceWithDiscount);
        }

        String debu1g = "";

        return resSales;
    }
}
