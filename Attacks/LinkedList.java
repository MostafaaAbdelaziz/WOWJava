package Attacks;
import java.util.List;
public class LinkedList {
    private Node head;
    int size;

    public LinkedList(){
        head = null;
        size = 0;
    }
    public LinkedList(List<String> original){
        for (String word : original){
            addLast(word);
        }
        size = original.size();
    }

    public void addFirst(String data){
        Node info = new Node(data);
        if(head == null){
            head = info;
        }
        else{
            info.setNext(head);
            head = info;
        }
    }

    public void addLast(String data){
        Node info = new Node(data);

        if(head == null){
            addFirst(info.getData());
        }
        else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(info);
        }
    }
    public int findFirst(String data){

        Node test = head;
        int index = 0;

        while(test != null){
            if(test.getData().equals(data)){
                return index;
            }
            test = test.getNext();
            index++;
        }
        return -1;
    }
    public int findLast(String data){
        int index = -1;
        Node otherTest = head;
        int counter = 0;

        while(otherTest != null){
            if(otherTest.getData().equals(data)){
                index = counter;
            }
            otherTest = otherTest.getNext();
            counter++;
        }
        return index;
    }
    public int getSize(){
        return size;
    }
    public String toString(){
        String text = "";

        Node inx = head;
        if(inx != null){
            while(inx.getNext() != null){
                text += (inx.getData() + " " + "->" + " ");
                inx = inx.getNext();
            }
            text += (inx.getData());
        }
        return text;
    }
}