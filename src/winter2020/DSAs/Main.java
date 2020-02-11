package winter2020.DSAs;

public class Main {

    public static void main(String[] args) {

        CoreData cd = new CoreData(1000000);
        SortTester st = new SortTester(cd);

        st.testSorts("FIFTY INTEGERS", 50);
        st.testSorts("ONE THOUSAND INTEGERS", 1000);
        st.testSorts("TEN THOUSAND INTEGERS", 10000);
        st.testSorts("ONE HUNDRED THOUSAND INTEGERS", 100000);
        st.testSorts("ONE MILLION INTEGERS", 1000000);

    }
}
