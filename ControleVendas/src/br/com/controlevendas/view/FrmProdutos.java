
package br.com.controlevendas.view;

import br.com.controlevendas.dao.ClientesDao;
import br.com.controlevendas.dao.FornecedoresDao;
import br.com.controlevendas.dao.ProdutosDao;
import br.com.controlevendas.model.Clientes;
import br.com.controlevendas.model.Fornecedores;
import br.com.controlevendas.model.Produtos;
import br.com.controlevendas.model.Utilitarios;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FrmProdutos extends javax.swing.JFrame {
   
    // Creates new form FrmCliente
    public FrmProdutos() {
        initComponents();
        
        // Inicia a aplicação no centro da tela
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        painel_produtos = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtdescricao = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtpreco = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtquantidade = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cbfornecedor = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtproduto = new javax.swing.JTextField();
        btnpesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        btnsalvar = new javax.swing.JButton();
        btnadicionar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnexcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 0));

        painel_produtos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Código:");

        txtcodigo.setEditable(false);
        txtcodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Descrição:");

        txtdescricao.setBackground(new java.awt.Color(255, 255, 255));
        txtdescricao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Preço:");

        txtpreco.setBackground(new java.awt.Color(255, 255, 255));
        txtpreco.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Quantidade:");

        txtquantidade.setBackground(new java.awt.Color(255, 255, 255));
        txtquantidade.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Fornecedor:");

        cbfornecedor.setBackground(new java.awt.Color(204, 204, 204));
        cbfornecedor.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cbfornecedor.setForeground(new java.awt.Color(0, 0, 0));
        cbfornecedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbfornecedorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout painel_produtosLayout = new javax.swing.GroupLayout(painel_produtos);
        painel_produtos.setLayout(painel_produtosLayout);
        painel_produtosLayout.setHorizontalGroup(
            painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_produtosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbfornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtquantidade)
                    .addComponent(txtpreco)
                    .addGroup(painel_produtosLayout.createSequentialGroup()
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 337, Short.MAX_VALUE))
                    .addComponent(txtdescricao))
                .addGap(620, 620, 620))
        );
        painel_produtosLayout.setVerticalGroup(
            painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_produtosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(cbfornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados do Produto", painel_produtos);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome:");

        txtproduto.setBackground(new java.awt.Color(255, 255, 255));
        txtproduto.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        txtproduto.setForeground(new java.awt.Color(0, 0, 0));

        btnpesquisar.setBackground(new java.awt.Color(204, 204, 204));
        btnpesquisar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnpesquisar.setForeground(new java.awt.Color(0, 0, 0));
        btnpesquisar.setText("Pesquisar");
        btnpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarActionPerformed(evt);
            }
        });

        tabelaProdutos.setBackground(new java.awt.Color(255, 255, 255));
        tabelaProdutos.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        tabelaProdutos.setForeground(new java.awt.Color(0, 0, 0));
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Preço", "Fornecedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(589, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisar))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Consulta de Produtos", jPanel3);

        btnsalvar.setBackground(new java.awt.Color(204, 204, 204));
        btnsalvar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnsalvar.setForeground(new java.awt.Color(0, 0, 0));
        btnsalvar.setText("SALVAR");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btnadicionar.setBackground(new java.awt.Color(204, 204, 204));
        btnadicionar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnadicionar.setForeground(new java.awt.Color(0, 0, 0));
        btnadicionar.setText("+ NOVO");
        btnadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadicionarActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(204, 204, 204));
        btneditar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btneditar.setForeground(new java.awt.Color(0, 0, 0));
        btneditar.setText("EDITAR");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnexcluir.setBackground(new java.awt.Color(204, 204, 204));
        btnexcluir.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnexcluir.setForeground(new java.awt.Color(0, 0, 0));
        btnexcluir.setText("EXCLUIR");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(btnadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btnsalvar)
                .addGap(73, 73, 73)
                .addComponent(btneditar)
                .addGap(90, 90, 90)
                .addComponent(btnexcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnadicionar, btneditar, btnexcluir, btnsalvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalvar)
                    .addComponent(btnadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar)
                    .addComponent(btnexcluir))
                .addGap(36, 36, 36))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnadicionar, btneditar, btnexcluir, btnsalvar});

        jTabbedPane2.getAccessibleContext().setAccessibleName("Dados do Produto");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Metodo Listar Produtos na Tabela
    public void listarProdutosTabela(){
        
        ProdutosDao dao = new ProdutosDao();
        List<Produtos> lista = dao.listarProdutos();
        
        DefaultTableModel dados = (DefaultTableModel) tabelaProdutos.getModel();
        dados.setNumRows(0);
        
        for(Produtos produtos: lista){
            
            dados.addRow(new Object[]{
                
                produtos.getId(),
                produtos.getDescricao(),
                produtos.getPreco(),
                produtos.getQtd_estoque(),
                produtos.getFornecedor().getNome()
        
            });
        }
        
    }
    
    // Altera um produto
    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        
        Produtos obj = new Produtos();
            
        // Pega os valores dos campos armazena nos atributos da Classe
        obj.setId(Integer.parseInt(txtcodigo.getText()));
        obj.setDescricao(txtdescricao.getText());
        obj.setPreco(Double.parseDouble(txtpreco.getText()));
        obj.setQtd_estoque(Integer.parseInt(txtquantidade.getText()));          
        
        // Cria um objeto fornecedor
        Fornecedores f = new Fornecedores();
        f = (Fornecedores) cbfornecedor.getSelectedItem();
            
        obj.setFornecedor(f);
        
        ProdutosDao dao = new ProdutosDao();
        dao.alterarProduto(obj);
        
        new Utilitarios().LimpaTela(painel_produtos);
        
    }//GEN-LAST:event_btneditarActionPerformed
    
    // Exclui um registro na tela de dados pessoais
    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        
        Produtos obj = new Produtos();
        
        obj.setId(Integer.parseInt(txtcodigo.getText()));
        
        ProdutosDao dao = new ProdutosDao();
        
        dao.excluirProduto(obj);
        
        new Utilitarios().LimpaTela(painel_produtos);
        
    }//GEN-LAST:event_btnexcluirActionPerformed
    
    // Limpa o campo para receber um novo registro
    private void btnadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadicionarActionPerformed
        
        new Utilitarios().LimpaTela(painel_produtos);
        
    }//GEN-LAST:event_btnadicionarActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed

        Produtos obj = new Produtos();
            
        obj.setDescricao(txtdescricao.getText());
        obj.setPreco(Double.parseDouble(txtpreco.getText()));
        obj.setQtd_estoque(Integer.parseInt(txtquantidade.getText()));
        
        // Cria e armazena o objeto selecionado
        Fornecedores f = new Fornecedores();
        f = (Fornecedores) cbfornecedor.getSelectedItem();
        obj.setFornecedor(f);
        
        ProdutosDao dao = new ProdutosDao();
        
        dao.cadastrarProduto(obj);
        
        new Utilitarios().LimpaTela(painel_produtos);
        
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        // Executa o metodo que recebe a lista de produtos e renderiza na tabela
        listarProdutosTabela();
    }//GEN-LAST:event_formWindowActivated
    
    // Evento de Click disparado ao clicar na linha da tabela
    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        
        // Chama o painel de acordo com o index da aba do painel
        // Nesse caso chama o painel de dados pessoais index 0
        jTabbedPane2.setSelectedIndex(0);
        
        txtcodigo.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString());
        txtdescricao.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 1).toString());
        txtpreco.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 2).toString());
        txtquantidade.setText(tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3).toString());
        
        
        Fornecedores fornecedor = new Fornecedores();
        
        FornecedoresDao dao = new FornecedoresDao();
        
        String nomeFornecedor = tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 4).toString();
       
        fornecedor = dao.buscaObjetoFornecedor(nomeFornecedor);
      
        cbfornecedor.setSelectedItem(fornecedor);
        
    }//GEN-LAST:event_tabelaProdutosMouseClicked
    
    // Busca um produto pelo nome
    private void btnpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarActionPerformed
        
        //descricao recebe o balor do campo de pesquisa
        String descricao = "%"+txtproduto.getText()+"%";
        
        ProdutosDao dao = new ProdutosDao();
        
        List<Produtos> lista = dao.buscaProdutoPorNome(descricao);
        
        DefaultTableModel dados = (DefaultTableModel) tabelaProdutos.getModel();
        dados.setNumRows(0);
        
        for(Produtos produtos :lista){
            
            dados.addRow(new Object[]{
                produtos.getId(),
                produtos.getDescricao(),
                produtos.getPreco(),
                produtos.getQtd_estoque(),
                produtos.getFornecedor().getNome()
            });
            
        }
    }//GEN-LAST:event_btnpesquisarActionPerformed
    
    // adiciona o nome do fornecedor no select de fornecedores
    private void cbfornecedorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbfornecedorAncestorAdded
        
       FornecedoresDao daof = new FornecedoresDao();
       
       List<Fornecedores> listaDeFornecedores = daof.listarFornecedores();
       
       // cbfornecedor.removeAll();
       for(Fornecedores f : listaDeFornecedores) {
           cbfornecedor.addItem(f);
       }
         
    }//GEN-LAST:event_cbfornecedorAncestorAdded
   
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new FrmProdutos().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadicionar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnpesquisar;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox cbfornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel painel_produtos;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtpreco;
    private javax.swing.JTextField txtproduto;
    private javax.swing.JTextField txtquantidade;
    // End of variables declaration//GEN-END:variables
}
