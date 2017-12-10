package View;

import Controller.Controller;
import Model.Product;
import Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cderienzo on 12/10/2017.
 */
public class ComprasPanel {
    private JPanel header;
    private JButton VISIONButton;
    private JButton EQUIPObutton;
    private JButton PERFILButton;
    private JLabel KWIKlabel;
    private JButton CARRITObutton;
    private JButton SEARCHbutton;
    private JPanel mainpanel;
    private JLabel resultsLabel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JButton comentarButton1;
    private JButton comentarButton2;
    private JButton comentarButton3;
    private JButton comentarButton4;
    private JButton comentarButton5;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private View.ViewSwapper vs;
    private int offset;
    private static final int PAGESIZE = 5;
    private ArrayList<Product> products;
    private HashMap<Product,Integer> ids;
    private Controller controller;



    public ComprasPanel(final View.ViewSwapper vs, final Controller controller) {
        this.vs = vs;
        this.controller = controller;
        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(offset >= PAGESIZE) {
                    offset -= PAGESIZE;
                    siguienteButton.setEnabled(true);
                }
                if(offset < PAGESIZE) {
                    anteriorButton.setEnabled(false);
                }
                refresh();

            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = products.size();
                if(size - offset > PAGESIZE) {
                    offset += PAGESIZE;
                    anteriorButton.setEnabled(true);
                }
                if(size - offset <= PAGESIZE) {
                    siguienteButton.setEnabled(false);
                }
                refresh();

            }
        });
        configureCommentsAction();

    }
    public void configureCommentsAction(){

        comentarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(products.size()>=1) {
                    Product curr = products.get(offset);
                    RateProduct rateProduct = View.getRateProduct();
                    rateProduct.setUpReview(curr,ids.get(curr));
                    vs.changeView("rateProductPanel",null);

                }
            }
        });
        comentarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(products.size()>=2) {
                    Product curr = products.get(offset+1);
                    RateProduct rateProduct = View.getRateProduct();
                    rateProduct.setUpReview(curr,ids.get(curr));
                    vs.changeView("rateProductPanel",null);

                }
            }
        });
        comentarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(products.size()>=3) {
                    Product curr = products.get(offset+2);
                    RateProduct rateProduct = View.getRateProduct();
                    rateProduct.setUpReview(curr,ids.get(curr));
                    vs.changeView("rateProductPanel",null);

                }
            }
        });
        comentarButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(products.size()>=4) {
                    Product curr = products.get(offset+3);
                    RateProduct rateProduct = View.getRateProduct();
                    rateProduct.setUpReview(curr,ids.get(curr));
                    vs.changeView("rateProductPanel",null);

                }
            }
        });
        comentarButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(products.size()>=5) {
                    Product curr = products.get(offset+4);
                    RateProduct rateProduct = View.getRateProduct();
                    rateProduct.setUpReview(curr,ids.get(curr));
                    vs.changeView("rateProductPanel",null);

                }
            }
        });
    }
    public void printResults(final ArrayList<Product> prods){
        cleanPanel();
        offset = 0;
        ids = Product.listBoughtProducts(controller.getCurrentUser());
        products = new ArrayList<>(ids.keySet());
        if(products.size()>PAGESIZE){
            siguienteButton.setEnabled(true);
        }
        refresh();
    }
    private void refresh(){
        ArrayList<Product> productList = new ArrayList<>();
        cleanPanel();
        int size = products.size();
        if(size >= 1 + offset) {
            Product prod = products.get(offset);

        }
        if(size>=2+offset) {
            Product prod = products.get(offset+1);
        }
        if(size>=3+offset) {
            Product prod = products.get(offset+2);

        }
        if(size>=4+offset) {
            Product prod = products.get(offset+3);

        }
        if(size>=5+offset) {
            Product prod = products.get(offset+4);

        }
    }

    private void cleanPanel(){}

    public JPanel getMainpanel() {
        return mainpanel;
    }

    public JButton getEQUIPObutton() {
        return EQUIPObutton;
    }

    public JButton getVISIONButton() {
        return VISIONButton;
    }

    public JButton getPERFILButton() {
        return PERFILButton;
    }

    public JButton getCARRITObutton() {
        return CARRITObutton;
    }

    public JButton getSEARCHbutton() {
        return SEARCHbutton;
    }

    public JButton getComentarButton1() {
        return comentarButton1;
    }

    public JButton getComentarButton2() {
        return comentarButton2;
    }

    public JButton getComentarButton3() {
        return comentarButton3;
    }

    public JButton getComentarButton4() {
        return comentarButton4;
    }

    public JButton getComentarButton5() {
        return comentarButton5;
    }
}
