package app.services;

import app.dto.add.AddSaleDto;
import app.dto.views.SaleWithDiscount;

import java.util.List;

public interface SalesService {
    void saveSale(AddSaleDto sale);

    List<SaleWithDiscount> getSalesWithAppliedDiscount();

}
