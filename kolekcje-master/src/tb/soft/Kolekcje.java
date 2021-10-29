package tb.soft;

import java.util.*;



public class Kolekcje {

    private LinkedList<Person> personLinkedList;
    private ArrayList<Person> personArrayList;
    private HashSet<Person> personHashSet;
    private TreeSet<Person> personTreeSet;
    private HashMap<String,Person> personHashMap;
    private TreeMap<String,Person> personTreeMap;

    public LinkedList<Person> getPersonLinkedList() {
        return personLinkedList;
    }

    public void setPersonLinkedList(LinkedList<Person> personLinkedList) {
        this.personLinkedList = personLinkedList;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public HashSet<Person> getPersonHashSet() {
        return personHashSet;
    }

    public void setPersonHashSet(HashSet<Person> personHashSet) {
        this.personHashSet = personHashSet;
    }

    public TreeSet<Person> getPersonTreeSet() {
        return personTreeSet;
    }

    public void setPersonTreeSet(TreeSet<Person> personTreeSet) {
        this.personTreeSet = personTreeSet;
    }

    public HashMap<String, Person> getPersonHashMap() {
        return personHashMap;
    }

    public void setPersonHashMap(HashMap<String, Person> personHashMap) {
        this.personHashMap = personHashMap;
    }

    public TreeMap<String, Person> getPersonTreeMap() {
        return personTreeMap;
    }

    public void setPersonTreeMap(TreeMap<String, Person> personTreeMap) {
        this.personTreeMap = personTreeMap;
    }

    /**
     * Konstruktor Kolekcji inicjalizuje atrybuty za pomocą metod wczytujące dane
     * z pliku z danymi "osoby.txt".
    */
    public Kolekcje (){
        this.personArrayList = Kolekcje.wczytywanieDanychZPlikuDoArrayList();
        this.personLinkedList = Kolekcje.wczytywanieDanychZPlikuDoLinkedList();
        this.personHashSet = Kolekcje.wczytywanieDanychZPlikuDoHashSet();
        this.personTreeSet = Kolekcje.wczytywanieDanychZPlikuDoTreeSet();
        this.personHashMap = Kolekcje.wczytywanieDanychZPlikuDoHashMap();
        this.personTreeMap = Kolekcje.wczytywanieDanychZPlikuDoTreeMap();
    }

    // METODY WCZYTUJACE DANE Z PLIKU DO ATRYBUTOW KLASY KOLEKCJE
    private static LinkedList<Person> wczytywanieDanychZPlikuDoLinkedList(){
        LinkedList<Person> personLinkedList1 = new LinkedList<>();
        for(int i = 0; i<10;i++){
            try {
                personLinkedList1.add(Person.readFromFile("osoby.txt",i));

            }catch (PersonException e){
                e.getMessage();
            }
        }
        return personLinkedList1;
    }

    private static ArrayList<Person> wczytywanieDanychZPlikuDoArrayList(){

        ArrayList<Person> personArrayList1 = new ArrayList<>();
        for(int i = 0; i<10;i++){
            try {
                personArrayList1.add(Person.readFromFile("osoby.txt",i));
            }catch (PersonException e){
                e.getMessage();
            }
        }
        return personArrayList1;
    }

    private static HashSet<Person> wczytywanieDanychZPlikuDoHashSet(){

        HashSet<Person> personHashSet1 = new HashSet<>();
        for (int i = 0; i<10; i++){
            try{
                personHashSet1.add(Person.readFromFile("osoby.txt",i));
            }catch (PersonException e){
                e.getMessage();
            }
        }
        return personHashSet1;
    }


    private static TreeSet<Person> wczytywanieDanychZPlikuDoTreeSet(){

        TreeSet<Person> personTreeSet1 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getLastName().equals(o2.getLastName())
                && o1.getFirstName().equals(o2.getFirstName())
                && o1.getBirthYear()==o2.getBirthYear())
                return 0;
                else return 1;
            }
        });

        for (int i = 0; i<10; i++){
            try{
                personTreeSet1.add(Person.readFromFile("osoby.txt",i));
            }catch (PersonException e){
                e.getMessage();
            }
        }
        return personTreeSet1;
    }

    private static HashMap<String,Person> wczytywanieDanychZPlikuDoHashMap(){

        HashMap<String,Person> personHashMap1 = new HashMap<>();
        for(int i = 0 ; i < 10; i++){
            try {
                Person person = Person.readFromFile("osoby.txt",i);
                personHashMap1.put(person.getLastName(),person);
            } catch (PersonException e ){
                e.getMessage();
            }
        }
        return personHashMap1;
    }

    private static TreeMap<String,Person> wczytywanieDanychZPlikuDoTreeMap(){

        TreeMap<String,Person> personTreeMap1 = new TreeMap<>();
        for(int i = 0 ; i < 10; i++){
            try {
                Person person = Person.readFromFile("osoby.txt",i);
                personTreeMap1.put(person.getLastName(),person);
            } catch (PersonException e ){
                e.getMessage();
            }
        }
        return personTreeMap1;
    }

    // METODY WYSWETLAJACE DANE ZAWARTOSC ATRYBUTOW KOLEKCJI
    public void wyswietlanieElementowLinkedList(LinkedList<Person> personLinkedList){
        int i=0;
        System.out.println("\nElementy LinkedList");
        for (Person person: personLinkedList) {
            System.out.println(i + "." + person.getFirstName() + " " + person.getLastName() + " " + person.getBirthYear() + " " + person.getJob() );
            i++;
        }
    }

    public void wyswietlanieElementowArrayList(ArrayList<Person> personArrayList){
        int i=0;
        System.out.println("\nElementy ArrayList");
        for(Person person: personArrayList){
            System.out.println(i + "." + person.getFirstName() + " " + person.getLastName() + " " + person.getBirthYear() + " " + person.getJob() );
            i++;
        }
    }

    public void wyswietlanieElementowHashSet(HashSet<Person> personHashSet){
        int i=0;
        System.out.println("\nElementy HashSet");
        for(Person person: personHashSet){
            System.out.println(i + "." + person.getFirstName() + " " + person.getLastName() + " " + person.getBirthYear() + " " + person.getJob() );
            i++;
        }
    }

    public void wyswietlanieElementowTreeSet(TreeSet<Person> personTreeSet){
        int i=0;
        System.out.println("\nElementy TreeSet");
        for(Person person: personTreeSet){
            System.out.println(i + "." + person.getFirstName() + " " + person.getLastName() + " " + person.getBirthYear() + " " + person.getJob() );
            i++;
        }
    }

    public static void wyswietlanieElementowHashMap(HashMap<String,Person> personHashMap){
        int i=0;
        System.out.println("\nElementy HashMap");
        for(String key : personHashMap.keySet()){
            Person person = personHashMap.get(key);
            System.out.println(i + ".Klucz: " + person.getLastName());
            System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getBirthYear() + " " + person.getJob() );
            i++;
        }

//        personHashMap.entrySet().forEach(stringPersonEntry -> {
//            System.out.println(i + "." + stringPersonEntry.getValue().getFirstName() + " " + stringPersonEntry.getValue().getLastName() + " " + stringPersonEntry.getValue().getBirthYear() + " " + stringPersonEntry.getValue().getJob());
//        });
    }

    public static void wyswietlanieElementowTreeMap(TreeMap<String,Person> personTreeMap){
        int i=0;
        System.out.println("\nElementy TreeMap");
        for(String key : personTreeMap.keySet()){
            Person person = personTreeMap.get(key);
            System.out.println(i + ".Klucz: " + person.getLastName());
            System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getBirthYear() + " " + person.getJob() );
            i++;
        }
//        personTreeMap.entrySet().forEach(stringPersonEntry -> {
//            System.out.println(i + "." + stringPersonEntry.getValue().getFirstName() + " " + stringPersonEntry.getValue().getLastName() + " " + stringPersonEntry.getValue().getBirthYear() + " " + stringPersonEntry.getValue().getJob());
//        });
    }

    public void wyswietlanieElementowKolekcji(Kolekcje kolekcja){
        kolekcja.wyswietlanieElementowLinkedList(kolekcja.getPersonLinkedList());
        kolekcja.wyswietlanieElementowArrayList(kolekcja.getPersonArrayList());
        kolekcja.wyswietlanieElementowHashSet(kolekcja.getPersonHashSet());
        kolekcja.wyswietlanieElementowTreeSet(kolekcja.getPersonTreeSet());
        kolekcja.wyswietlanieElementowHashMap(kolekcja.getPersonHashMap());
        kolekcja.wyswietlanieElementowTreeMap(kolekcja.getPersonTreeMap());
    }

    public void dodawnieNowegoPersonDoLinkedList(Person person, LinkedList<Person> kolekcje){
        kolekcje.add(person);
    }
    public void dodawnieNowegoPersonDoArrayList(Person person, ArrayList<Person> kolekcje){
        kolekcje.add(person);
    }
    public void dodawnieNowegoPersonDoHashSet(Person person, HashSet<Person> kolekcje){
        kolekcje.add(person);
    }
    public void dodawnieNowegoPersonDoTreeSet(Person person, TreeSet<Person> kolekcje){
        kolekcje.add(person);
    }
    public void dodawnieNowegoPersonDoHashMap(Person person, HashMap<String,Person> kolekcje){
        kolekcje.put(person.getLastName(),person);
    }

    public void dodawnieNowegoPersonDoTreeMap(Person person, TreeMap<String,Person> kolekcje){
        kolekcje.put(person.getLastName(),person);
    }

    public void usuwaniePersonZArrayList(ArrayList<Person> personArrayList){
        Scanner scanner = new Scanner(System.in);
        int index;
        System.out.print("Podaj nr indeksu osoby ktora chcesz usuac: ");
        index = scanner.nextInt();
        personArrayList.remove(index);
    }

    public void usuwaniePersonZLinkedList(LinkedList<Person> personLinkedList){
        Scanner scanner = new Scanner(System.in);
        int index;
        System.out.print("Podaj nr indeksu osoby ktora chcesz usuac: ");
        index = scanner.nextInt();
        personLinkedList.remove(index);
    }

    public void usuwaniePersonZHashSet(HashSet<Person> personHashSet){
        Scanner scanner = new Scanner(System.in);
        int index;
        System.out.print("Podaj nr indeksu osoby ktora chcesz usuac: ");
        index = scanner.nextInt();
        personHashSet.remove(index);
    }

    public void usuwaniePersonZTreeSet(TreeSet<Person> personTreeSet){
        Scanner scanner = new Scanner(System.in);
        int index;
        System.out.print("Podaj nr indeksu osoby ktora chcesz usuac: ");
        index = scanner.nextInt();
        personTreeSet.remove(index);
    }

    public void usuwaniePersonZHashMap(HashMap<String,Person> personHashMap){
        Scanner scanner = new Scanner(System.in);
        String klucz;
        System.out.print("Podaj klucz warosci ktora chcesz usunac: ");
        klucz=scanner.next();
        personHashMap.remove(klucz);
    }

    public void usuwaniePersonZTreeMap(TreeMap<String,Person> treeMap){
        Scanner scanner = new Scanner(System.in);
        String klucz;
        System.out.print("Podaj klucz warosci ktora chcesz usunac: ");
        klucz=scanner.next();
        treeMap.remove(klucz);
    }





}
