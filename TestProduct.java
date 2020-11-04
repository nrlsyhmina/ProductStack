import javax.swing.*;
import java.util.Stack;
public class TestProduct
{
    public static void main(String[] argd)
    {
        Stack prodStack = new Stack();
        String type, color, size;
        double price;
        char c;
        
        //a) store 10 products into stack, prodStack
        for(int i=0; i<2 ; i++)
        {
            type = JOptionPane.showInputDialog("Enter Type: ");
            color = JOptionPane.showInputDialog("Enter Color: ");
            size = JOptionPane.showInputDialog("Enter Size: ");
            c = size.charAt(0);
            price = Double.parseDouble(type = JOptionPane.showInputDialog("Enter Price: "));
            Product pro = new Product();
            pro.setData(type, color, c , price);
            prodStack.push(pro);
        }
        
        //b)Remove all the products from the prodStack and store them into
        //THREE different stacks (shortSleeve, shortPants, and booties). 
        //All products in the prodStack must remain in the original order.
        
        Stack shortsleeve = new Stack();
        Stack shortPants = new Stack();
        Stack booties = new Stack();
        Stack tempStack = new Stack();
        
        Object obj;
        Product temp;
        
        while(!prodStack.isEmpty())
        {
            obj = prodStack.pop();
            temp = (Product) obj;
            tempStack.push(temp);
            
            if(temp.getType().equalsIgnoreCase("short sleeve"))
            {
                shortsleeve.push(obj);
            }
            
            else if(temp.getType().equalsIgnoreCase("short pant"))
            {
                shortPants.push(obj);
            }
            else
            {
                booties.push(obj);
            }
        }
        
        Object obj1;
        while(!tempStack.isEmpty()) {
            obj1 = tempStack.pop();
            prodStack.push(obj1);
        }
        
        //c)Calculate and display the tota
        Object ob;
        Product po;
        double total = 0.00, total1=0.00, total2=0.0;
        
        while(!shortsleeve.isEmpty())
        {
            ob = shortsleeve.pop();
            po = (Product)ob;
            total += po.getPrice();
            tempStack.push(po);
        }
        
        while(!tempStack.isEmpty())
        {
            obj1 = tempStack.pop();
            shortsleeve.push(obj1);
        }
        
        System.out.println("Total price for short sleeve is :RM " + total);
        
        while(!shortPants.isEmpty())
        {
            ob = shortPants.pop();
            po = (Product) ob;
            total1+=po.getPrice();
        }
        System.out.println("Total price for short pants is :RM " + total1);
        
        while(!booties.isEmpty())
        {
            ob = booties.pop();
            po = (Product) ob;
            total2+=po.getPrice();
        }
        System.out.println("Total price for booties is :RM " + total2);
        
        //d)Display all the types and prices pf the products size M and blue
        String a = "", b = "", g = "", d = "", e = "", f = "";
        while(!prodStack.isEmpty())
        {
            ob = prodStack.pop();
            po = (Product)ob;
            if(po.getSize()=='m' || po.getSize()=='M' && po.getColor().equalsIgnoreCase("blue"))
            {
                a+=po.getType() + "\t" + po.getPrice() + "\n";
            }
        }
        System.out.println("Display: \n" + a);
        
    }
}
