package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 9.3.1
        System.out.println("=== 9.3.1 ===");
        List<Integer> numere = new Random().ints(10, 5, 26).boxed().collect(Collectors.toList());
        System.out.println("Lista: " + numere);
        
        // a) Suma
        int sum = numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println("a) Suma: " + sum);
        
        // b) Max si Min
        int max = numere.stream().mapToInt(Integer::intValue).max().orElse(0);
        int min = numere.stream().mapToInt(Integer::intValue).min().orElse(0);
        System.out.println("b) Max: " + max + ", Min: " + min);
        
        // c) Interval [10..20]
        List<Integer> filteredList = numere.stream().filter(n -> n >= 10 && n <= 20).collect(Collectors.toList());
        System.out.println("c) Elementele in [10..20]: " + filteredList);
        
        // d) Double
        List<Double> doubleList = numere.stream().map(Integer::doubleValue).collect(Collectors.toList());
        System.out.println("d) Lista de Double: " + doubleList);
        
        // e) Contine 12
        boolean contains12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("e) Se gaseste valoarea 12 in lista: " + contains12);

        // 9.3.2
        System.out.println("\n=== 9.3.2 ===");
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> words = Arrays.asList(text.split(" "));
        
        // a) 
        List<String> wordsGe5 = words.stream().filter(w -> w.length() >= 5).collect(Collectors.toList());
        long countGe5 = words.stream().filter(w -> w.length() >= 5).count();
        System.out.println("a) Cuvinte >= 5 caractere (numar: " + countGe5 + "): " + wordsGe5);
        
        // b) 
        List<String> sortedWordsGe5 = wordsGe5.stream().sorted().collect(Collectors.toList());
        System.out.println("b) Lista noua ordonata: " + sortedWordsGe5);
        
        // c) 
        String pWord = words.stream().filter(w -> w.startsWith("p")).findFirst().orElse("Niciunul");
        System.out.println("c) Un element care incepe cu 'p': " + pWord);

        // 9.3.3
        System.out.println("\n=== 9.3.3 ===");
        List<Student> studentiCuNote = Arrays.asList(
            new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
            new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
            new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
            new Student(1029, "Bianca", "Popescu", "TI131/1", 10),
            new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
            new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
            new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
            new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
            new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        // a)
        System.out.println("a) Studenti cu nota 10:");
        studentiCuNote.stream().filter(s -> s.getNota() == 10).forEach(System.out::println);

        // b)
        System.out.println("\nb) Studenti cu nota sub 5:");
        studentiCuNote.stream().filter(s -> s.getNota() < 5).forEach(System.out::println);

        // c)
        System.out.println("\nc) Lista transformata (nota < 4 devine 4):");
        List<Student> transformedStudents = studentiCuNote.stream().map(s -> {
            if (s.getNota() < 4) {
                return new Student(s.getId(), s.getPrenume(), s.getNume(), s.getGrupa(), 4.0);
            }
            return s;
        }).collect(Collectors.toList());
        transformedStudents.forEach(System.out::println);

        // d)
        double sumGrades = studentiCuNote.stream().map(Student::getNota).reduce(0.0, Double::sum);
        System.out.println("\nd) Suma notelor tuturor studentilor: " + sumGrades);

        // e)
        double avgGrades = sumGrades / studentiCuNote.size();
        System.out.println("e) Media (reduce la suma + impartire la size): " + avgGrades);
    }
}
