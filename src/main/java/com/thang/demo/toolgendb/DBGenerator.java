//package com.thang.demo.toolgendb;
//
//import com.thang.demo.entity.*;
//import com.thang.demo.infrastructure.ConvertDateToLong;
//import com.thang.demo.infrastructure.constant.GenderProductDetail;
//import com.thang.demo.infrastructure.constant.Roles;
//import com.thang.demo.infrastructure.constant.Status;
//import com.thang.demo.repository.AddressRepository;
//import com.thang.demo.repository.BillDetailRepository;
//import com.thang.demo.repository.BillHistoryRepository;
//import com.thang.demo.repository.BillRepository;
//import com.thang.demo.repository.CartDetailRepository;
//import com.thang.demo.repository.CartRepository;
//import com.thang.demo.repository.CategoryRepository;
//import com.thang.demo.repository.ColorRepository;
//import com.thang.demo.repository.FormRepository;
//import com.thang.demo.repository.ImageRepository;
//import com.thang.demo.repository.NotifycationRepository;
//import com.thang.demo.repository.PayMentMethodRepository;
//import com.thang.demo.repository.ProductDetailRepository;
//import com.thang.demo.repository.ProductRepository;
//import com.thang.demo.repository.SizeRepository;
//import com.thang.demo.repository.UserRepository;
//import com.thang.demo.repository.UserVocherRepository;
//import com.thang.demo.repository.VoucherDetailRepository;
//import com.thang.demo.repository.VoucherRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@SpringBootApplication
//@EnableJpaRepositories(
//        basePackages = "com.thang.demo.repository")
//public class DBGenerator implements CommandLineRunner {
//
//    @Autowired
//    private UserVocherRepository accountVoucherRepository;
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    @Autowired
//    private BillHistoryRepository billHistoryRepository;
//
//    @Autowired
//    private BillDetailRepository billDetailRepository;
//
//    @Autowired
//    private BillRepository billRepository;
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private CartDetailRepository cartDetailRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private ColorRepository colorRepository;
//
//    @Autowired
//    private ImageRepository imageRepository;
//
//    @Autowired
//    private NotifycationRepository notificationRepository;
//
//    @Autowired
//    private PayMentMethodRepository paymentsMethodRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ProductDetailRepository productDetailRepository;
//
//    @Autowired
//    private SizeRepository sizeRepository;
//
//    @Autowired
//    private FormRepository formRepository;
//
//
//    @Autowired
//    private VoucherRepository voucherRepository;
//
//    @Autowired
//    private VoucherDetailRepository voucherDetailRepository;
//
//    @Autowired
//    private UserRepository userReposiory;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Category category = Category.builder().name("Áo nam").status(Status.DANG_SU_DUNG).build();
//        Category category1 = Category.builder().name("Áo nữ").status(Status.DANG_SU_DUNG).build();
//        categoryRepository.save(category);
//        categoryRepository.save(category1);
//
//        Product product = Product.builder().name("Áo abc").status(Status.DANG_SU_DUNG).build();
//        Product product1 = Product.builder().name("Áo 2").status(Status.DANG_SU_DUNG).build();
//        Product product2 = Product.builder().name("Áo 3").status(Status.DANG_SU_DUNG).build();
//        Product product3 = Product.builder().name("Áo 4").status(Status.DANG_SU_DUNG).build();
//         productRepository.save(product);
//        productRepository.save(product1);
//        productRepository.save(product2);
//        productRepository.save(product3);
//
//        Color color = Color.builder().code("#ccc").name("Xám").build();
//        Color color1 = Color.builder().code("#ddd").name("đỏ").build();
//        Color color2 = Color.builder().code("#cfc").name("cam").build();
//        colorRepository.save(color);
//        colorRepository.save(color1);
//        colorRepository.save(color2);
//
//        Size size = Size.builder().name(45).build();
//        Size size1 = Size.builder().name(40).build();
//        Size size2 = Size.builder().name(23).build();
//        sizeRepository.save(size);
//        sizeRepository.save(size1);
//        sizeRepository.save(size2);
//
//        Form form = Form.builder().name("a").build();
//        Form form1 = Form.builder().name("b").build();
//        Form form2 = Form.builder().name("c").build();
//        formRepository.save(form);
//        formRepository.save(form1);formRepository.save(form2);
//
//
//        ProductDetail productDetail = ProductDetail.builder().gender(GenderProductDetail.NAM).price(new BigDecimal("100000")).quantity(100).category(category).size(size).product(product1).color(color).form(form1).build();
//        ProductDetail productDetail1 = ProductDetail.builder().gender(GenderProductDetail.NAM).price(new BigDecimal("300000")).quantity(100).category(category1).size(size1).product(product1).form(form1).color(color).build();
//        ProductDetail productDetail2 = ProductDetail.builder().gender(GenderProductDetail.NU).price(new BigDecimal("100540")).quantity(100).category(category).size(size2).product(product2).form(form2).color(color2).build();
//        ProductDetail productDetail3 = ProductDetail.builder().gender(GenderProductDetail.NU).price(new BigDecimal("45550440")).quantity(100).category(category).size(size).product(product2).form(form).color(color).build();
//        ProductDetail productDetai4 = ProductDetail.builder().gender(GenderProductDetail.NU).price(new BigDecimal("700000")).quantity(100).category(category1).size(size).product(product).form(form).color(color).build();
//        ProductDetail productDetail5 = ProductDetail.builder().gender(GenderProductDetail.NAM_VA_NU).price(new BigDecimal("100000")).quantity(100).category(category).size(size2).product(product3).form(form2).color(color1).build();
//        ProductDetail productDetail6 = ProductDetail.builder().gender(GenderProductDetail.NAM_VA_NU).price(new BigDecimal("100000")).quantity(100).category(category).size(size).product(product1).form(form).color(color1).build();
//        ProductDetail productDetail7 = ProductDetail.builder().gender(GenderProductDetail.NAM_VA_NU).price(new BigDecimal("100000")).quantity(100).category(category).size(size1).product(product2).form(form).color(color).build();
//        productDetailRepository.save(productDetail);
//        productDetailRepository.save(productDetail1);
//        productDetailRepository.save(productDetail2);
//        productDetailRepository.save(productDetail3);
//        productDetailRepository.save(productDetai4);
//        productDetailRepository.save(productDetail5);
//        productDetailRepository.save(productDetail7);
//        productDetailRepository.save(productDetail6);
//
//        // Tạo một danh sách các giá trị cho mỗi thuộc tính
//        List<String> fullNames = Arrays.asList("Nguyễn Văn A", "Trần Thị B", "Lê Văn C", "Đỗ Thị D", "Phạm Văn E");
//        List<Long> dateOfBirths = Arrays.asList(946702800000L, 978302400000L, 1009896000000L, 1041489600000L, 1072977600000L);
//        List<String> phoneNumbers = Arrays.asList("0987654321", "0912345678", "0901234567", "0989876543", "0912345678");
//        List<String> emails = Arrays.asList("a@gmail.com", "b@gmail.com", "c@gmail.com", "d@gmail.com", "e@gmail.com");
//        List<Boolean> genders = Arrays.asList(true, false, true, false, true);
//        List<String> avatas = Arrays.asList("https://example.com/avatar1.png", "https://example.com/avatar2.png", "https://example.com/avatar3.png", "https://example.com/avatar4.png", "https://example.com/avatar5.png");
//        List<Integer> pointss = Arrays.asList(0, 0, 0, 0, 0);
//        List<String> citizenIdentities = Arrays.asList("123456789", "987654321", "123456789", "987654321", "123456789");
//        List<Roles> roless = Arrays.asList(Roles.ADMIN, Roles.USER, Roles.USER, Roles.USER, Roles.USER, Roles.USER);
//
//        for (int i = 0; i < 5; i++) {
//            User user = User.builder()
//                    .fullName(fullNames.get(i))
//                    .dateOfBirth(dateOfBirths.get(i))
//                    .phoneNumber(phoneNumbers.get(i))
//                    .email(emails.get(i))
//                    .gender(genders.get(i))
//                    .avata(avatas.get(i))
//                    .points(pointss.get(i))
//                    .citizenIdentity(citizenIdentities.get(i))
//                    .status(Status.DANG_SU_DUNG)
//                    .roles(roless.get(i))
//                    .password(new BCryptPasswordEncoder().encode("123456"))
//                    .build();
//            userReposiory.save(user);
//            Cart cart = Cart.builder().user(user).build();
//            cartRepository.save(cart);
//        }
//
//
//        productDetailRepository.save(productDetail);
//        Voucher voucher1 = Voucher.builder().code("VC889")
//                .name("Sale ngày khai trương").value(new BigDecimal(100000))
//                .startDate(new ConvertDateToLong().dateToLong("25/05/2023")).endDate(new ConvertDateToLong().dateToLong("01/12/2023"))
//                .quantity(100).status(Status.DANG_SU_DUNG).build();
//        Voucher voucher2 = Voucher.builder().code("VC8f89")
//                .name("Sale sốc").value(new BigDecimal(100000))
//                .startDate(new ConvertDateToLong().dateToLong("15/06/2023")).endDate(new ConvertDateToLong().dateToLong("25/12/2023"))
//                .quantity(100).status(Status.DANG_SU_DUNG).build();
//        voucherRepository.save(voucher2);
//        voucherRepository.save(voucher1);
//
//    }
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx = SpringApplication.run(DBGenerator.class);
//        ctx.close();
//    }
//}
