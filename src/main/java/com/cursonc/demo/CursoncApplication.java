package com.cursonc.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursonc.demo.domain.Categoria;
import com.cursonc.demo.domain.Cidade;
import com.cursonc.demo.domain.Cliente;
import com.cursonc.demo.domain.Endereco;
import com.cursonc.demo.domain.Estado;
import com.cursonc.demo.domain.ItemPedido;
import com.cursonc.demo.domain.Pagamento;
import com.cursonc.demo.domain.PagamentoBoleto;
import com.cursonc.demo.domain.PagamentoCartao;
import com.cursonc.demo.domain.Pedido;
import com.cursonc.demo.domain.Produto;
import com.cursonc.demo.domain.enums.EstadoPagamento;
import com.cursonc.demo.domain.enums.TipoCliente;
import com.cursonc.demo.repositories.CategoriaRepository;
import com.cursonc.demo.repositories.CidadeRepository;
import com.cursonc.demo.repositories.ClienteRepository;
import com.cursonc.demo.repositories.EnderecoRepository;
import com.cursonc.demo.repositories.EstadoRepository;
import com.cursonc.demo.repositories.ItemPedidoRepository;
import com.cursonc.demo.repositories.PagamentoRepository;
import com.cursonc.demo.repositories.PedidoRepository;
import com.cursonc.demo.repositories.ProdutoRepository;


@SpringBootApplication
public class CursoncApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository repo;
	
	@Autowired
	ProdutoRepository produtoRepo;
	
	@Autowired
	CidadeRepository citRepo;
	
	@Autowired
	EstadoRepository estRepo;
	@Autowired
	ClienteRepository clirepo;
	@Autowired
	EnderecoRepository endrepo;
	@Autowired
	PedidoRepository pedidorepo;
	@Autowired
	PagamentoRepository pagamentorepo;
	@Autowired
	ItemPedidoRepository itempedidorepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoncApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Produto p1 = new Produto(null,"Computador",2000.0);
		Produto p2 = new Produto(null,"Ipressoara",800.0);
		Produto p3 = new Produto(null,"Mouse",80.0);
		
		//adiciona os produtos ao objeto das categorias
		cat.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat.getProdutos().addAll(Arrays.asList(p2));
		
		//vincula as categorias aos produtos
		p1.getCategorias().addAll(Arrays.asList(cat));
		p2.getCategorias().addAll(Arrays.asList(cat,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat));
		
		Estado sp = new Estado(null,"São Paulo");
		Estado mg = new Estado(null,"Minas Gerais");
		Cidade Campinas = new Cidade(null,"Campinas",sp);
		Cidade Bh = new Cidade(null,"Belo Horizonte",mg);
		
		//é necessario interligar as duas entidades nesse caso o estado com a cidade
		//adiciona a cidade de campinas à lista de cidaddes do estado sp
		sp.getCidades().addAll(Arrays.asList(Campinas));
		mg.getCidades().addAll(Arrays.asList(Bh));
		
		Cliente cli1 = new Cliente("Joao","j@gmail.com","22299988844",null,TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("1166775817","11966775542"));
		
		Cliente cli2 = new Cliente("Armando","j@gmail.com","22299988844",null,TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("1166775817","11966775542"));
		
		Endereco end1 = new Endereco(null,"Rua Flores","Hardim","06755400","11","casa",cli2,Campinas);
		Endereco end2 = new Endereco(null,"Rua Andaluz","Hardim","06755100","110","casa",cli2,Bh);
		cli2.getEnderecos().addAll(Arrays.asList(end1,end2));
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		Cliente cli3 = new Cliente();
		cli3.setId(3);
		cli3.setCpfOuCnpj("34567890098");
		cli3.setEmail("jhjhj");
		cli3.setNome("jkajsas");
		cli3.getTelefones().addAll(Arrays.asList("1166775817","11966775542"));
		cli3.setTipo(TipoCliente.PESSOAFISICA.getDescricao());
		
		
	//	arara azul = new arara(null,"azul");
	//	arara verde = new arara(null,"verde");
	//	arararepo.saveAll(Arrays.asList(azul,verde));
		
		Cliente cli4 = new Cliente();
		cli4.setId(3);
		cli4.setCpfOuCnpj("34567890098");
		cli4.setEmail("jhjhj");
		cli4.setNome("jkajsas");
		cli4.getTelefones().addAll(Arrays.asList("1166775817","11966775542"));
		cli4.setTipo(TipoCliente.PESSOAFISICA.getDescricao());
		//cli4.setArara(azul);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido pedido1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,end1);
		Pedido pedido2 = new Pedido(null,sdf.parse("10/10/2017 10:32"),cli1,end2);
		
		Pagamento pag1 = new PagamentoCartao(null,EstadoPagamento.QUITADO,pedido1,6);
		pedido1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoBoleto(null,EstadoPagamento.PENDENTE,pedido2,sdf.parse("20/10/2017 00:00"),null);
		pedido2.setPagamento(pag2);
		cli1.getPedidos().addAll(Arrays.asList(pedido1,pedido2));
		
		
		
		
		//JOptionPane.showMessageDialog(null, cli1.getTipo().getDescricao());
		repo.saveAll(Arrays.asList(cat,cat2));
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		estRepo.saveAll(Arrays.asList(sp,mg));
		citRepo.saveAll(Arrays.asList(Campinas,Bh));
		clirepo.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		endrepo.saveAll(Arrays.asList(end1,end2));
		pedidorepo.saveAll(Arrays.asList(pedido1,pedido2));
		pagamentorepo.saveAll(Arrays.asList(pag1,pag2));
		
		ItemPedido ip1 = new ItemPedido(pedido1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(pedido1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(pedido2,p2,100.00,1,800.00);
		
		pedido1.getItens().addAll(Arrays.asList(ip1,ip2));
		pedido2.getItens().addAll(Arrays.asList(ip3));
		
		//produto conhece sua lista de itens de pedido
		p1.getItens().add(ip1);
		p2.getItens().add(ip3);
		p3.getItens().add(ip2);
		
		itempedidorepo.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}

}
