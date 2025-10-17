import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição Mentoria Java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso1);
//        System.out.println(curso2);
//        System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devNathan = new Dev();
        devNathan.setNome("Nathan");
        devNathan.inscreverBotcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Nathan:" + devNathan.getConteudosInscritos());
        devNathan.progredir();
        devNathan.progredir();
        System.out.println("-----------------------");
        System.out.println("Conteúdos Concluidos Nathan:" + devNathan.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos Nathan:" + devNathan.getConteudosInscritos());
        System.out.println("XP: "+ devNathan.calcularTotalXp());

        System.out.println("-----------------------");

        Dev devDyenis = new Dev();
        devDyenis.setNome("Dyenis");
        devDyenis.inscreverBotcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Dyenis:" + devDyenis.getConteudosInscritos());
        devDyenis.progredir();
        devDyenis.progredir();
        devDyenis.progredir();
        System.out.println("-----------------------");
        System.out.println("Conteúdos Concluidos Dyenis:" + devDyenis.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos Dyenis:" + devDyenis.getConteudosInscritos());
        System.out.println("XP: "+ devDyenis.calcularTotalXp());



    }
}
