package payment;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.teamfive.payment.web.controller.PaymentController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PaymentController.class)
public class PaymentControllerTest {
	
	@Autowired
	private MockMvc mvc;
	

}
