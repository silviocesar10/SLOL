package edu.ifes.ci.si.les.slol.services;

import edu.ifes.ci.si.les.slol.model.*;
import edu.ifes.ci.si.les.slol.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;

@Service
public class _DBService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaLivroRepository categoriaLivroRepository;
	//@Autowired
	//private ReservaRepository reservaRepository;
	
	@Autowired 
	private ReservaService rsvService;	
	
	public  void instantiateTestDatabase() throws ParseException, IOException {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("cheguei aqui");
        Cliente cl1 = new Cliente(01, "Joao", "000.000.000-01", "Maria 1", "br1", "brasil1", sdf.parse("1999-07-06"), "(28)99999-9999", true);
		Cliente cl2 = new Cliente(02, "Jose", "000.000.000-02", "Maria 1", "br1", "brasil1", sdf.parse("1994-03-06"), "(28)99999-9998", false);
		
		CategoriaLivro catLvr1 = new CategoriaLivro(01, "Terror", "Livros com historias de terror", sdf.parse("2022-05-18"));
		CategoriaLivro catLvr2 = new CategoriaLivro(02, "Fantasia", "Livros com historias de fantasias", sdf.parse("2022-05-18"));
		
		Livro lvr1 = new Livro(01, "Harry Potter e a Pedra Filosofal", "Harry Potter e a Pedra Filosofal é o primeiro dos sete livros da série de fantasia Harry Potter, escrita por J. K. Rowling.","972-23-2533-7", "J. K. Rowling", sdf.parse("1999-10-14"),catLvr2);
		Livro lvr2 = new Livro(02, "O Iluminado", "The Shining é um romance de horror do escritor estadunidense Stephen King.","9788573022035", "Stephen King", sdf.parse("1977-01-28"),catLvr1);
		//olha as datas aqui nada conflita, so a ultima que ta comentada
		
		Reserva rsv1 = new Reserva(01, sdf.parse("2022-07-18"), sdf.parse("2022-10-25"),sdf.parse("2022-10-27"), 0.0F, 3,cl1, lvr1);
		Reserva rsv2 = new Reserva(02, sdf.parse("2022-07-18"), sdf.parse("2022-08-12"),sdf.parse("2022-08-15"), 0.0F, 3,cl2, lvr2);
		Reserva rsv3 = new Reserva(03, sdf.parse("2022-07-18"), sdf.parse("2022-07-13"),sdf.parse("2022-07-16"), 0.0F, 3,cl2, lvr2);
		Reserva rsv4 = new Reserva(04, sdf.parse("2022-07-18"), sdf.parse("2022-07-01"),sdf.parse("2022-06-04"), 0.0F, 3,cl2, lvr2);
		Reserva rsv5 = new Reserva(05, sdf.parse("2022-07-18"), sdf.parse("2022-07-06"),sdf.parse("2022-07-09"), 0.0F, 3,cl2, lvr2);
		
		//tentado inserir reserva com conflito
		//Reserva rsv6 = new Reserva(06, sdf.parse("2022-06-18"), sdf.parse("2022-08-12"),sdf.parse("2022-08-14"), 0.0F, 3,cl2, lvr2);
		categoriaLivroRepository.save(catLvr1);
		categoriaLivroRepository.save(catLvr2);
		
		livroRepository.save(lvr1);
		livroRepository.save(lvr2);
		
		clienteRepository.save(cl1);
		clienteRepository.save(cl2);
		
		//reservaRepository.save(rsv1);
		//reservaRepository.save(rsv2);
		//reservaRepository.save(rsv3);
		//reservaRepository.save(rsv4);
		//reservaRepository.save(rsv5);
		//reservaRepository.save(rsv6);
		rsvService.insert(rsv1);
		rsvService.insert(rsv2);
		rsvService.insert(rsv3);
		rsvService.insert(rsv4);
		rsvService.insert(rsv5);
		//rsvService.insert(rsv6);
	}
}
