package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public ModelAndView home() {
		
//		Pedido pedido = new Pedido();
//		pedido.setNomeProduto("Dave Grohl - O Contador de Histórias: Memórias de Vida e Música");
//		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/41FAElBHlHL._SY498_BO1,204,203,200_.jpg");
//		pedido.setUrlProduto("https://www.amazon.com.br/gp/product/6555605588/");
//		pedido.setDescricao("Livro de memórias de Dave Grohl traz relato emocionante sobre a vida de um dos maiores nomes do rock internacional");
//		pedido.setDataEntrega(LocalDate.now());
//		pedido.setValorNegociado(BigDecimal.valueOf(59.90));
//		
//		List<Pedido> pedidos = Arrays.asList(pedido);
		
//		List<Pedido> pedidos = pedidoRepository.findAll();
//		model.addAttribute("pedidos", pedidos);		
//		return "home";
		
		ModelAndView mv = new ModelAndView("home");
		List<Pedido> pedidos = pedidoRepository.findAll();
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
	@GetMapping("/{status}")
	public String status(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError( ) {
		return "redirect:/home";
	}
	
}
