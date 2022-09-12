//package com.brightly.service;
//
//import io.quarkus.test.junit.QuarkusTest;
//import io.quarkus.test.junit.mockito.InjectMock;
//import org.junit.jupiter.api.Test;
//
//import javax.inject.Inject;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@QuarkusTest
//class PurchaseOrderServiceImplTest {
//
//    @Inject
//    private PurchaseOrderService gPOService;
//
//    @InjectMock
//    private PurchaseOrderRepository gPORepo;
//
//    @Test
//    void createPurchaseOrder() {
//        PurchaseOrder vPO = new PurchaseOrder();
//        vPO.setId(1l);
//        assertEquals(vPO.getId(), gPOService.createPurchaseOrder(vPO).getId());
//    }
//
//    @Test
//    void getPurchaseOrderById() {
//        assertEquals(null, gPOService.getPurchaseOrderById(1l));
//    }
//}