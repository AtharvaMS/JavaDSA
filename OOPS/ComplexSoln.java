



class Complex{
    int real;
    int img;

    public Complex(int r, int i){
        real = r;
        img = i;
    }


    public static Complex add(Complex a, Complex b){
        return new Complex(a.real + b.real, a.img+b.img);
    }

    public static Complex diff(Complex a , Complex b){
        return new Complex(a.real - b.real, a.img - b.img);
    }

    public static Complex mul( Complex a , Complex b ){
        return new Complex(((a.real*b.real)-(a.img*b.img)), ((a.real*b.img)+(a.img*b.real)));
    }

    public  static void printNum(Complex a){
        if(a.real == 0 && a.img !=0){
            System.out.println("0+"+ a.img+"i");
        }
        else if(a.real != 0 && a.img ==0){
            System.out.println(a.real + "+0i");
        }
        else{
            System.out.println(a.real+"+"+a.img+"i");
        }
    }
}




public class ComplexSoln{
    public static void main(String[] args) {
        
        Complex p = new Complex(4, 5);
        Complex q =  new Complex(3, 4);

        Complex r = Complex.add(p, q);
        Complex s =  Complex.diff(p,q);
        Complex t =  Complex.mul(p, q);

        Complex.printNum(r);
        Complex.printNum(s);
        Complex.printNum(t);

    }
}


