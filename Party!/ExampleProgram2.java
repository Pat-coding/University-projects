public class MyClass <T > {
    private T [] x ;
    public static int b = 4;
    public MyClass () {
        x = new T [3];
        b = 7;
    }
    public static void main ( String [] args ) {
        MyClass < Integer > m = new MyClass < Integer >();
        System . out . println ( m . b );
    }
}