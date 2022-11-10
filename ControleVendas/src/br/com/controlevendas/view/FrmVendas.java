
package br.com.controlevendas.view;

import br.com.controlevendas.dao.ClientesDao;
import br.com.controlevendas.dao.ProdutosDao;
import br.com.controlevendas.model.Clientes;
import br.com.controlevendas.model.Produtos;
import br.com.controlevendas.model.Utilitarios;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmVendas extends javax.swing.JFrame {
    
    double total;
    double preco;
    double subtotal;
    int quantidade;
    
    DefaultTableModel carrinho;
    
    Clientes clientes = new Clientes();

    // Creates new form FrmCliente
    public FrmVendas() {
        initComponents();
        
        // Quantidade inicia com valor 1
        txtquantidade.setText("1");
        
        // Inicia a aplicação no centro da tela
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtcpf = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnConsultaPorCPF = new javax.swing.JButton();
        txtdataatual = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtdescricao = new javax.swing.JTextField();
        btnConsultaCodigoProduto = new javax.swing.JButton();
        txtcodigo = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtpreco = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtquantidade = new javax.swing.JTextField();
        btnAdicionarProduto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JTextField();
        btnPagamento = new javax.swing.JButton();
        btnCancelarVenda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Vendas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ponto de Vendas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("CPF:");

        txtcpf.setBackground(new java.awt.Color(255, 255, 255));
        txtcpf.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcpf.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtcpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcpfActionPerformed(evt);
            }
        });
        txtcpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcpfKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Nome:");

        txtnome.setBackground(new java.awt.Color(255, 255, 255));
        txtnome.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Data:");

        btnConsultaPorCPF.setBackground(new java.awt.Color(153, 153, 153));
        btnConsultaPorCPF.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnConsultaPorCPF.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultaPorCPF.setText("Pesquisa");
        btnConsultaPorCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaPorCPFActionPerformed(evt);
            }
        });

        txtdataatual.setEditable(false);
        txtdataatual.setBackground(new java.awt.Color(255, 255, 255));
        txtdataatual.setForeground(new java.awt.Color(0, 0, 0));
        txtdataatual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat(""))));
        txtdataatual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdataatual.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultaPorCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdataatual)))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtdataatual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaPorCPF))
                .addGap(58, 58, 58))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Código:");

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Produto:");

        txtdescricao.setBackground(new java.awt.Color(255, 255, 255));
        txtdescricao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        btnConsultaCodigoProduto.setBackground(new java.awt.Color(153, 153, 153));
        btnConsultaCodigoProduto.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnConsultaCodigoProduto.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultaCodigoProduto.setText("Pesquisa");
        btnConsultaCodigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCodigoProdutoActionPerformed(evt);
            }
        });

        txtcodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoKeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Preço:");

        txtpreco.setBackground(new java.awt.Color(255, 255, 255));
        txtpreco.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Qtd:");

        txtquantidade.setBackground(new java.awt.Color(255, 255, 255));
        txtquantidade.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        btnAdicionarProduto.setBackground(new java.awt.Color(153, 153, 153));
        btnAdicionarProduto.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnAdicionarProduto.setForeground(new java.awt.Color(0, 0, 0));
        btnAdicionarProduto.setText("Adicionar Item");
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultaCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaCodigoProduto))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrinho de Compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Qtd", "Preço", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaItens);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Total da Venda:");

        txtTotalVenda.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalVenda.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        txtTotalVenda.setForeground(new java.awt.Color(0, 0, 0));

        btnPagamento.setBackground(new java.awt.Color(153, 153, 153));
        btnPagamento.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnPagamento.setForeground(new java.awt.Color(0, 0, 0));
        btnPagamento.setText("Pagamento");
        btnPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagamentoActionPerformed(evt);
            }
        });

        btnCancelarVenda.setBackground(new java.awt.Color(153, 153, 153));
        btnCancelarVenda.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnCancelarVenda.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelarVenda.setText("Cancelar Venda");
        btnCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVenda))
                .addGap(30, 30, 30))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelarVenda, btnPagamento});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    // Confirma o pagamento da compra
    private void btnPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagamentoActionPerformed
        
        // Instancia a tela de pagamentos
        FrmPagamentos telaPagamentos = new FrmPagamentos();
        
        // Ao instanciar uma tela em outra temos acesso as 
        // variaveis (publicas) dos campos da tela instanciada
        
        // Agora posso passar o valor do atributo total para tela de pagemantos
        telaPagamentos.txttotal.setText(String.valueOf(total));
        
        // O objeto Clientes é armazenado no atributo publico cliente_id do FrmPagamentos
        telaPagamentos.cliente_id = clientes;
        telaPagamentos.carrinho = carrinho;
        
        // ao clicar no botão pagamento com o valor no atributo total
        // abre a tela de finalizar pagamentos que foi instanciada em telaPagamentos
        telaPagamentos.setVisible(true);
        
        // this se refere a tela atual dispose esconde a tela de PDV
        this.dispose();
        
    }//GEN-LAST:event_btnPagamentoActionPerformed
    
    // Cancela a venda no PDV
    private void btnCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVendaActionPerformed

        
        
       
        
    }//GEN-LAST:event_btnCancelarVendaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        // Inicia o input data com a data atual do sistema
        Date dataAtual = new Date();
        
        SimpleDateFormat dataBr = new SimpleDateFormat("dd/MM/yyyy");
        
        String dataFormatada = dataBr.format(dataAtual);
        
        txtdataatual.setText(dataFormatada);
        
    }//GEN-LAST:event_formWindowActivated
    
    // Busca um cliente pelo CPF
    private void btnConsultaPorCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaPorCPFActionPerformed

        ClientesDao dao = new ClientesDao();
            
        // Passo como parametro o cpf e pego o retorno do dao em obj
        clientes = dao.buscaClientePorCPF(txtcpf.getText());
            
        // retiro o nome do objeto retornado do dao e insiro no input txtnome
        txtnome.setText(clientes.getNome());
            
    }//GEN-LAST:event_btnConsultaPorCPFActionPerformed
    
    // Busca produto pelo ID (Código)
    private void btnConsultaCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCodigoProdutoActionPerformed
        
        Produtos obj = new Produtos();
        ProdutosDao dao = new ProdutosDao();
            
        // Passo como parametro o id e pego o retorno do dao em obj
        obj = dao.buscaProdutoPorCodigo(Integer.parseInt(txtcodigo.getText()));
            
        // retiro o nome do objeto retornado do dao e insiro no input txtPRODUTO
        txtdescricao.setText(obj.getDescricao());
        txtpreco.setText(String.valueOf(obj.getPreco()));
        
    }//GEN-LAST:event_btnConsultaCodigoProdutoActionPerformed
    
    // Adiciona um item de produto a venda
    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        
        quantidade = Integer.parseInt(txtquantidade.getText());
        preco = Double.parseDouble(txtpreco.getText());
        
        subtotal = quantidade * preco;
        
        // Total recebe o valor total mais o subtotal (Primeiro soma+ depois adiciona = o resultado em total)
        total += subtotal;
        
        // Primeiro converte para String devido o campo esperar um texto e não um inteiro
        txtTotalVenda.setText(String.valueOf(total));
        
        // Adiciona o produto na tabela (Carrinho de Compras)
        carrinho = (DefaultTableModel) tabelaItens.getModel();
        
        carrinho.addRow(new Object[]{
            txtcodigo.getText(),
            txtdescricao.getText(),
            txtquantidade.getText(),
            txtpreco.getText(),
            subtotal
        });
        
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    private void txtcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcpfActionPerformed

    }//GEN-LAST:event_txtcpfActionPerformed
    
    // Faz a busca por CPF ao apertar a tecla ENTER
    private void txtcpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpfKeyPressed
        
        // Evento pega o numero da tecla
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            ClientesDao dao = new ClientesDao();
            
            // Passo como parametro o cpf e pego o retorno do dao em obj
            clientes = dao.buscaClientePorCPF(txtcpf.getText());
            
            // retiro o nome do objeto retornado do dao e insiro no input txtnome
            txtnome.setText(clientes.getNome());
            
        }
        
    }//GEN-LAST:event_txtcpfKeyPressed
    
    // Busca um produto pelo Código
    private void txtcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            Produtos obj = new Produtos();
            ProdutosDao dao = new ProdutosDao();
            
            // Passo como parametro o id e pego o retorno do dao em obj
            obj = dao.buscaProdutoPorCodigo(Integer.parseInt(txtcodigo.getText()));
            
            // retiro o nome do objeto retornado do dao e insiro no input txtPRODUTO
            txtdescricao.setText(obj.getDescricao());
            txtpreco.setText(String.valueOf(obj.getPreco()));
            
        }
        
    }//GEN-LAST:event_txtcodigoKeyPressed
   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new FrmVendas().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnConsultaCodigoProduto;
    private javax.swing.JButton btnConsultaPorCPF;
    private javax.swing.JButton btnPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTextField txtTotalVenda;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JFormattedTextField txtcpf;
    private javax.swing.JFormattedTextField txtdataatual;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtpreco;
    private javax.swing.JTextField txtquantidade;
    // End of variables declaration//GEN-END:variables
}
