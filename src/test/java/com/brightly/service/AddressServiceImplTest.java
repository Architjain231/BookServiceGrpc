//package com.brightly.service;
//
//import io.quarkus.test.junit.QuarkusTest;
//import io.quarkus.test.junit.mockito.InjectMock;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import javax.inject.Inject;
//import java.util.Arrays;
//import java.util.List;
//
//@QuarkusTest
//class AddressServiceImplTest {
//
//    @Inject
//    AddressService gAddressService;
//
//    @InjectMock
//    AddressRepository gAddressRepo;
//
//    @BeforeEach
//    void before(){
//    }
//
//    @Test
//    void getAddressById() {
//        Address vAddress = new Address();
//        vAddress.setZip("122003");
//        vAddress.setId(1l);
//        Mockito.when(gAddressRepo.findById(1l)).thenReturn(vAddress);
//        Assertions.assertEquals("122003", gAddressService.getAddressById(1l).getZip());
//    }
//
//    @Test
//    void getAddressListByIds() {
//        Address vAddress = new Address();
//        vAddress.setZip("122003");
//        vAddress.setId(1l);
//        List<Address> vList = Arrays.asList(vAddress);
//        Mockito.when(gAddressRepo.list("id",Arrays.asList(1l))).thenReturn(vList);
//        Assertions.assertEquals(vList.size(), gAddressService.getAddressListByIds(Arrays.asList(1l)).size());
//    }
//}