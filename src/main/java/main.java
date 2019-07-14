import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by heymn on 29.10.2018.
 */
public class main {


    public static Support s = new Support(); // ������������� ������ Support


    public void setAll (String data_textfield1, String data_textfield2, String data_textfield3){   // �������� ��������� ������ � �����
        s.setData(s.getEl("#content tr:nth-child(1) input.gwt-TextBox"), data_textfield1);
        s.setData(s.getEl("#content tr:nth-child(2) input.gwt-TextBox"), data_textfield2);
        s.setData(s.getEl("#content input.sideWithMistake"), data_textfield3);
        s.click(s.getEl("button.gwt-Button"));
    }

    public HashMap<String, String> getAll(){                                     // ��������� ������ �� ������� � ���������� �� �����
        HashMap <String, String> map = new HashMap<String, String>();
        String answer = s.getData(s.getEl("div.answerLabel"));
        String error1 = s.getData(s.getEl("#content tr:nth-child(1) div.gwt-Label"));
        String error2 = s.getData(s.getEl("#content tr:nth-child(2) div.gwt-Label"));
        String error3 = s.getData(s.getEl("div.validationError"));
        map.put("answer", answer);
        map.put("error1", error1);
        map.put("error2", error2);
        map.put("error3", error3);
        return map;
    }

    public static HashMap<String, String> triangle_variant(){                // �������� ����������� ������� � ������ �������������
        HashMap <String, String> map = new HashMap<String, String>();
        map.put("equilateral", "��������������");
        map.put("isosceles", "��������������");
        map.put("not_triangle", "�� �����������");
        map.put("rectangular", "Rectangular");
        map.put("different", "��������������");
        return map;
    }

    public static HashMap<String, String> error_variant(){                  // ��������� ����������� ������� � ���������� ������
        HashMap <String, String> map = new HashMap<String, String>();
        map.put("null","���� �� ������ ���� ������");
        map.put("not_string", "'�� �������� ���������� ������");
        return map;
    }



    public static void main (String [] args){                       // ����� ����� � ������������
        HashMap <String, String> tr_var;                           // ������������� ����������� ������
        tr_var = triangle_variant();

        HashMap <String, String> er_var;
        er_var = error_variant();


        PrintStream out = null;                                     // ��������� ������ ���������
        try {
            out = new PrintStream(System.out, true, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        main main = new main();


        try {                                              // ������ ������������
            main.test15(tr_var, er_var);
            main.test16(tr_var, er_var);
            main.test17(tr_var, er_var);
            main.test18(tr_var, er_var);
            main.test19(tr_var, er_var);
            main.test20(tr_var, er_var);
            main.test21(tr_var, er_var);
            main.test22(tr_var, er_var);
            main.test23(tr_var, er_var);
            main.test27(tr_var, er_var);
            main.test28(tr_var, er_var);
            main.test29(tr_var, er_var);
            main.test30(tr_var, er_var);
            main.test31(tr_var, er_var);
            main.test32(tr_var, er_var);
            main.test34(tr_var, er_var);
            main.test35(tr_var, er_var);
            main.test36(tr_var, er_var);
            main.test37(tr_var, er_var);
            main.test38(tr_var, er_var);

        } catch (Exception ex){
            ex.printStackTrace();
        }

        s.stopDriver();                                     //����� ������ �� ������������
    }





    public void test15(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap <String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 15. �������� ����� ������ ������");
        setAll("", "2", "3");
        map1 = getAll();

        if (s.comparison(map1.get("error1"), error_variant.get("null")) == true){
            System.out.println("���1 - ��������");}
        else { System.out.println("���1 - �� ��������. ��������� - " + " ������ ���� ������: "+map1.get("error1"));
        }

        setAll("2", "", "3");
        map1 = getAll();
        if (s.comparison(map1.get("error2"), error_variant.get("null")) == true){
            System.out.println("���2 - ��������");}
        else { System.out.println("���2 - �� ��������. ��������� -" + " ������ ���� ������: "+map1.get("error2"));
        }

        setAll("2", "3", "");
        map1 = getAll();
        if (s.comparison(map1.get("error3"), error_variant.get("null")) == true){
            System.out.println("���3 - ��������");}
        else { System.out.println("���3 - �� ��������. ��������� -"+ " ������ ���� ������: "+map1.get("error3"));
        }

        setAll("", "", "");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error2"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error3"), error_variant.get("null")) == true)){
            System.out.println("���4 - ��������");}
        else { System.out.println("���4 - �� ��������. ��������� - " + " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


    }






    public void test16(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap <String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 16. �������� ����� ������ �����");
        setAll("1", "", "");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), error_variant.get("null")) == false) &&
                (s.comparison(map1.get("error2"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error3"), error_variant.get("null")) == true))  {
        System.out.println("���1 - ��������");}
        else { System.out.println("���1 - �� ��������. ��������� -"+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("", "2", "");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error2"), error_variant.get("null")) == false) &&
                (s.comparison(map1.get("error3"), error_variant.get("null")) == true))  {
            System.out.println("���2 - ��������");}
        else { System.out.println("���2 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("", "", "3");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error2"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error3"), error_variant.get("null")) == false))  {
        System.out.println("���3 - ��������");}
        else { System.out.println("���3 - �� ��������. ��������� -"+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }
    }






    public void test17(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap <String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 17. �������� ����� ������������� �����");
        setAll("1.1", "", "");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), error_variant.get("null")) == false) &&
                (s.comparison(map1.get("error2"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error3"), error_variant.get("null")) == true))  {
            System.out.println("���1 - ��������");}
        else { System.out.println("���1 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("", "2.2", "");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error2"), error_variant.get("null")) == false) &&
                (s.comparison(map1.get("error3"), error_variant.get("null")) == true))  {
            System.out.println("���2 - ��������");}
        else { System.out.println("���2 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("", "", "3.3");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error2"), error_variant.get("null")) == true) &&
                (s.comparison(map1.get("error3"), error_variant.get("null")) == false))  {
            System.out.println("���3 - ��������");}
        else { System.out.println("���3 - �� ��������.��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }
    }






    public void test18(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap <String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 18. �������� �� ������� �� ����� �����");
        setAll(" 1", " 1", " 1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "' 1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "' 1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "' 1"+error_variant.get("not_string")) == false))  {
            System.out.println("���1 - ��������");}
        else { System.out.println("���1 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("2.2 ", "2.2 ", "2.2 ");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), "'2.2 "+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'2.2 "+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'2.2 "+error_variant.get("not_string")) == false))  {
            System.out.println("���2 - ��������");}
        else { System.out.println("���2 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll(" 3 ", " 3 ", " 3 ");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), "' 3 "+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "' 3 "+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "' 3 "+error_variant.get("not_string")) == false))  {
            System.out.println("���3 - ��������");}
        else { System.out.println("���3 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }
    }






    public void test19(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap <String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 19. �������� �� ������� � �������� �����");
        setAll("1 1", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1 1"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���1 - ��������");}
        else { System.out.println("���1 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        s.reload_page();

        setAll("1", "1 1", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1 1"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���2 - ��������");}
        else { System.out.println("���2 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        s.reload_page();

        setAll("1", "1", "1 1");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1 1"+error_variant.get("not_string")) == true))  {
            System.out.println("���3 - ��������");}
        else { System.out.println("���3 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }
    }





    public void test20(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap <String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 20. �������� �� 0 � ���� �����");
        setAll("0", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'0"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���1 - ��������");}
        else { System.out.println("���1 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


        setAll("1", "0", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "0"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���2 - ��������");}
        else { System.out.println("���2 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


        setAll("1", "1", "0");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'0"+error_variant.get("not_string")) == false))  {
            System.out.println("���3 - ��������");}
        else { System.out.println("���3 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }
    }




    public void test21(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap <String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 21. �������� �� ������������� ����� � ���� �����");
        setAll("-1", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'-1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���1 - ��������");}
        else { System.out.println("���1 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


        setAll("1", "-1", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "-1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���2 - ��������");}
        else { System.out.println("���2 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


        setAll("1", "1", "-1");
        map1 = getAll();
        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'-1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'0"+error_variant.get("not_string")) == false))  {
            System.out.println("���3 - ��������");}
        else { System.out.println("���3 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }
    }




    public void test22(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 22. �������� �� ��������� ��� ������");
        setAll("fff", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'fff" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("fff4", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'fff4" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("4fff", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'4fff" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("fff4fff", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'fff4fff" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


        setAll("4fff4", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'4fff4" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "fff", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'fff" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "fff4", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'fff4" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���7 - ��������");
        } else {
            System.out.println("���7 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "4fff", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'4fff" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���8 - ��������");
        } else {
            System.out.println("���8 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "fff4fff", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'fff4fff" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���9 - ��������");
        } else {
            System.out.println("���9 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "4fff4", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'4fff4" + error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1" + error_variant.get("not_string")) == false)) {
            System.out.println("���10 - ��������");
        } else {
            System.out.println("���10 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


        setAll("1", "1", "fff");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'fff" + error_variant.get("not_string")) == true)) {
            System.out.println("���11 - ��������");
        } else {
            System.out.println("���11 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "1", "fff4");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'fff4" + error_variant.get("not_string")) == true)) {
            System.out.println("���12 - ��������");
        } else {
            System.out.println("���12 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "1", "4fff");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'4fff" + error_variant.get("not_string")) == true)) {
            System.out.println("���13 - ��������");
        } else {
            System.out.println("���13 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "1", "fff4fff");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'fff4fff" + error_variant.get("not_string")) == true)) {
            System.out.println("���14 - ��������");
        } else {
            System.out.println("���14 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "1", "4fff4");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1" + error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'4fff4" + error_variant.get("not_string")) == true)) {
            System.out.println("���15 - ��������");
        } else {
            System.out.println("���15 - �� ��������. ��������� -"+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

    }




    public void test23(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap <String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 23. �������� �� �����������");
        setAll("%", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'%"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���1 - ��������");}
        else { System.out.println("���1 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("%4", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'%4"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���2 - ��������");}
        else { System.out.println("���2 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("4%", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'4%"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���3 - ��������");}
        else { System.out.println("���3 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("%4%", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'%4%"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���4 - ��������");}
        else { System.out.println("���4 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


        setAll("4%4", "1", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'4%4"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���5 - ��������");}
        else { System.out.println("���5 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "%", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'%"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���6 - ��������");}
        else { System.out.println("���6 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "%4", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'%4"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���7 - ��������");}
        else { System.out.println("���7 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "4%", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'4%"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���8 - ��������");}
        else { System.out.println("���8 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "%4%", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'%4%"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���9 - ��������");}
        else { System.out.println("���9 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "4%4", "1");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'4%4"+error_variant.get("not_string")) == true) &&
                (s.comparison(map1.get("error3"), "'1"+error_variant.get("not_string")) == false))  {
            System.out.println("���10 - ��������");}
        else { System.out.println("���10 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }


        setAll("1", "1", "%");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'%"+error_variant.get("not_string")) == true))  {
            System.out.println("���11 - ��������");}
        else { System.out.println("���11 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "1", "%4");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'%4"+error_variant.get("not_string")) == true))  {
            System.out.println("���12 - ��������");}
        else { System.out.println("���12 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "1", "4%");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'4%"+error_variant.get("not_string")) == true))  {
            System.out.println("���13 - ��������");}
        else { System.out.println("���13 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "1", "$4%");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'$4%"+error_variant.get("not_string")) == true))  {
            System.out.println("���14 - ��������");}
        else { System.out.println("���14 - �� ��������. ��������� - "+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

        setAll("1", "1", "4%4");
        map1 = getAll();

        if ((s.comparison(map1.get("error1"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error2"), "'1"+error_variant.get("not_string")) == false) &&
                (s.comparison(map1.get("error3"), "'4%4"+error_variant.get("not_string")) == true))  {
            System.out.println("���15 - ��������");}
        else { System.out.println("���15 - �� ��������. ��������� -"+ " ������ ���� ������: " +map1.get("error1")+" ������ ���� ������: "+ map1.get("error2")+ " ������ ���� ������: "+ map1.get("error3"));
        }

    }




    public void test27(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 27. �������� �� ���� ������ � ������������� ����� ������������");
        setAll("1", "1", "1.1");
        map1 = getAll();

        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���1 - ��������");
            } else {System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));}


        setAll("1", "1.1", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���2 - ��������");
        } else {System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));}

        setAll("1.1", "1", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���3 - ��������");
        } else {System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));}


        setAll("1.2", "1.1", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���4 - ��������");
        } else {System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));}


        setAll("1.2", "1", "1.1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���5 - ��������");
        } else {System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));}


        setAll("1", "1.2", "1.1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���6 - ��������");
        } else {System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));}
    }




    public void test28(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 28.  ���� ������ ������ � ���� �, �, �");

        setAll("1", "1", "");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        setAll("1", "", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        setAll("", "1", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("", "", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("", "1", "");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("1", "", "");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));}

    }





    public void test29(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 29.  ���� ��������� ���������� ������ � �������� � ���� �, �, �");

        setAll("1", "1", "f");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        setAll("1", "f", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        setAll("f", "1", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("f", "f", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("f", "1", "f");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("1", "f", "f");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));}

    }




    public void test30(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 30. ���� ������������ ������ � ������� � ���� �, �, �");

        setAll("1", "1", "%");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        setAll("1", "%", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        setAll("%", "1", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("%", "%", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("%", "1", "%");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }


        setAll("1", "%", "%");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) ||
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));}

    }




    public void test31(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 31. �������� �� �������������� �����������");

        setAll("12", "12", "14");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("12", "14", "12");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("14", "12", "12");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("12.5", "12.5", "15");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("12.5", "15", "12.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("15", "12.5", "12.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));}

    }




    public void test32(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 32. �������� �� �������������� �����������");

        setAll("12", "12", "12");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("12.5555", "12.5555", "12.5555");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }
    }

    public void test34(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 34. �������� �� ������������� �����������");

        setAll("3", "4", "5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("3", "5", "4");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("4", "3", "5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("4", "5", "3");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("5", "3", "4");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("5", "3", "4");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.48546295", "75.2347126", "75.1963478");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���7 - ��������");
        } else {
            System.out.println("���7 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.48546295", "75.1963478", "75.2347126");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���8 - ��������");
        } else {
            System.out.println("���8 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("75.1963478", "75.2347126", "2.48546295");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���9 - ��������");
        } else {
            System.out.println("���9 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("75.1963478", "2.48546295", "75.2347126");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���10 - ��������");
        } else {
            System.out.println("���10 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("75.2347126", "75.1963478", "2.48546295");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���11 - ��������");
        } else {
            System.out.println("���11 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("75.2347126", "2.48546295", "75.1963478");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���12 - ��������");
        } else {
            System.out.println("���12 - �� ��������. ��������� -"+map1.get("answer"));
        }

    }




    public void test35(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 35. �������� �� ������������� �������������� ����������� ");

        setAll("2", "2", "2.82842713");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2", "2.82842713", "4");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.82842713", "2", "2");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.5", "2.5", "3.5355339");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.5", "3.5355339", "2.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("3.5355339", "2.5", "2.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));
        }
    }




    public void test36(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 36. �������� �� ����������� � ������� ���������");

        setAll("2", "3", "4");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2", "4", "3");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("3", "2", "4");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("3", "4", "2");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("4", "3", "2");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("4", "2", "3");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.5", "3.5", "4.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���7 - ��������");
        } else {
            System.out.println("���7 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.5", "4.5", "3.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���8 - ��������");
        } else {
            System.out.println("���8 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("3.5", "4.5", "2.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���9 - ��������");
        } else {
            System.out.println("���9 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("3.5", "2.5", "4.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���10 - ��������");
        } else {
            System.out.println("���10 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("4.5", "3.5", "2.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���11 - ��������");
        } else {
            System.out.println("���11 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("4.5", "2.5", "3.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == true)) {
            System.out.println("���12 - ��������");
        } else {
            System.out.println("���12 - �� ��������. ��������� -"+map1.get("answer"));
        }

    }





    public void test37(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 37. �������� �� ����������� �����������");

        setAll("1", "2", "3");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("1", "3", "2");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2", "1", "3");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2", "3", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("3", "2", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("3", "1", "2");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("1.5", "2.75", "4.25");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���7 - ��������");
        } else {
            System.out.println("���7 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("1.5", "4.25", "2.75");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���8 - ��������");
        } else {
            System.out.println("���8 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.75", "4.25", "1.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���9 - ��������");
        } else {
            System.out.println("���9 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.75", "1.5", "4.25");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���10 - ��������");
        } else {
            System.out.println("���10 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("4.25", "2.75", "1.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���11 - ��������");
        } else {
            System.out.println("���11 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("4.25", "1.5", "2.75");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���12 - ��������");
        } else {
            System.out.println("���12 - �� ��������. ��������� -"+map1.get("answer"));
        }

    }




    public void test38(HashMap<String, String> triangle_variant, HashMap<String, String> error_variant) {
        HashMap<String, String> map1 = new HashMap<String, String>();

        s.go("https://team.cft.ru/triangle/zadanie/triangle.html?token=b2745e35aaf84d469c61e37f7596116e");
        System.out.println("���� 38. �������� �� �� �����������");

        setAll("1", "2", "789");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���1 - ��������");
        } else {
            System.out.println("���1 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("1", "789", "2");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���2 - ��������");
        } else {
            System.out.println("���2 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2", "1", "789");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���3 - ��������");
        } else {
            System.out.println("���3 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2", "789", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���4 - ��������");
        } else {
            System.out.println("���4 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("789", "2", "1");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���5 - ��������");
        } else {
            System.out.println("���5 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("789", "1", "2");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���6 - ��������");
        } else {
            System.out.println("���6 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("1.5", "2.75", "789.25");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���7 - ��������");
        } else {
            System.out.println("���7 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("1.5", "789.25", "2.75");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���8 - ��������");
        } else {
            System.out.println("���8 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.75", "789.25", "1.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���9 - ��������");
        } else {
            System.out.println("���9 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("2.75", "1.5", "789.25");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���10 - ��������");
        } else {
            System.out.println("���10 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("789.25", "2.75", "1.5");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���11 - ��������");
        } else {
            System.out.println("���11 - �� ��������. ��������� -"+map1.get("answer"));
        }

        s.reload_page();

        setAll("789.25", "1.5", "2.75");
        map1 = getAll();
        if ((s.comparison(map1.get("answer"), triangle_variant.get("equilateral")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("isosceles")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("not_triangle")) == true) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("rectangular")) == false) &&
                (s.comparison(map1.get("answer"), triangle_variant.get("different")) == false)) {
            System.out.println("���12 - ��������");
        } else {
            System.out.println("���12 - �� ��������. ��������� -"+map1.get("answer"));
        }

    }



}





