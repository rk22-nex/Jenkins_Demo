package CSV.writeread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.data.model.message.Message;
import com.wildbit.java.postmark.client.data.model.message.MessageResponse;
import com.wildbit.java.postmark.client.exception.PostmarkException;





public class write {
	
	
	public static void main(String[] arg) {
		
		
		String path ="C:\\Mobi_config\\toyyibpaycsv\\";
		String filename = "TOYYIB PAY settlement report.csv";
		//String patteren=".csv";
		try {
		//PrintWriter p = new PrintWriter(new File("C:\\Users\\hp\\Desktop\\write.csv"));
		//StringBuilder sb= null;
			//FileWriter writer = new FileWriter("C:\\Users\\hp\\Desktop\\writee.csv");
			
			FileWriter writer = new FileWriter(path+filename);
		dbconnection d = new dbconnection();
		Connection con = d.getconnection();
		String settledatee= ExCommons.getFile().getProperty("SETTLEMENTDATE");
		String settledat1 = settledatee + "%";
		System.out.println(settledat1);
		String settledate = "'"+settledat1+"'";
		System.out.println(settledate);
		 // String query ="select * from studentdb ";
String query ="select m.BUSINESS_NAME,mm.UM_EZYWAY_MID as MID, (u.TXN_AMOUNT ) Amount,"
	    + " u.MASKED_PAN as Cardnumber , u.INVOICE_ID as InvoiceId,u.SETTLEMENTDATE as SettlementDate,u.SETTLETYPE,u.MDR_AMT,"
	    + " u.CARD_BRAND,u.CARD_CURR,u.CARD_TYPE,u.DATE from mobiversa.MERCHANT m "
	    + " inner join mobiversa.MID mm on m.ID=mm.MERCHANT_FK"
	    + " inner join mobiversa.SETTLEMENT_MDR u on u.MID = mm.UM_EZYWAY_MID"
	    + " where m.MM_ID = 'TOYYIBPAY' and u.`STATUS` in ('A','S','C')  and u.SETTLEMENTDATE like "+settledate  ;
	//String query="SELECT BUSINESS_NAME, ID,VERSION ,ID,MID_FK,AGID_FK FROM merchant WHERE ID='1'";

		
	
        PreparedStatement ps = con.prepareStatement(query);
		  ResultSet rs = ps.executeQuery();

		 
		  ArrayList<Employee> employees = new ArrayList<Employee>();
		 while(rs.next()) {
			  Employee e =new Employee();
			 
//			 e.setEmpno(Integer.parseInt(rs.getString(1)));
//			 e.setEmpname(rs.getString(2));
//			 e.setPosition(rs.getString(3));
			 e.setBusinessname(rs.getString(1));
			e.setMid(Integer.parseInt(rs.getString(2)));
			// e.setMidd(rs.getString(2));
			 e.setAmount(rs.getString(3));
			 e.setCardnumber(rs.getString(4));
			 e.setInvoiceid(rs.getString(5));
			 
			 if(rs.getString(6) != null) {
			
				 String rd = null;
	                try {
	                      rd = new SimpleDateFormat("dd-MM-yyyy")
	                                    .format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(6).toString()));
	                } catch (ParseException E) {
	                      // TODO Auto-generated catch block
	                      E.printStackTrace();
	                }
	               
			 e.setSettlementdate(rd);
			 }
			 e.setSettletype(rs.getString(7));
			 e.setMdramt(rs.getString(8).substring(0,4));
			 e.setCardbrand(rs.getString(9));
			 e.setCardcurr(rs.getString(10));
			 e.setCardtype(rs.getString(11));
			 e.setDate(rs.getString(12));
			 
			 


 
			
			 employees.add(e);
		 // System.out.println(employees); 
			
		 }
		
		 writer.append("BUSINESS_NAME");
		 writer.append("  ");
			writer.append(",");

         writer.append("MID");
   		writer.append(",");
         writer.append("Amount");
   		writer.append(",");

         writer.append("Cardnumber");
   		writer.append(",");

			writer.append("Invoiceid");
   		writer.append(",");

			writer.append("Settlement Date");
			writer.append(",");
			
			writer.append("SettleType");
			writer.append(",");
			
			writer.append("Mdr_Amt");
			writer.append(",");
			
			writer.append("Cardbrand");
			writer.append(",");
			
			
			writer.append("Cardcurrency");
			writer.append(",");
			
			writer.append("Cardtype");
			writer.append(",");
			
			writer.append("Date");
			writer.append(",");
			
			
			
			
   		writer.append("\n");
		 
		
		 for(Employee ee:employees) {
			 // sb= new StringBuilder();
			  
//			    sb.append(String.valueOf(ee.getEmpno()));
//				sb.append(",");
//				sb.append(ee.getEmpname());
//				sb.append(",");
//				sb.append(ee.getPosition());
//				sb.append("\n");
			
//			    writer. append(String.valueOf(ee.getEmpno()));
//				writer.append(",");
//				writer.append(ee.getEmpname());
//				writer.append(",");
//				writer.append(ee.getPosition());
//				writer.append("\n");
				writer.append(ee.getBusinessname());
     			writer.append(",");

	            writer.append(String.valueOf(ee.getMid()));
	      		writer.append(",");
	           // writer.append(String.valueOf(ee.getAmount()));
	      		writer.append(ee.getAmount());
	      		writer.append(",");

	          //  writer.append(String.valueOf(ee.getCardnumber()));
	      		writer.append(ee.getCardnumber());
	      		writer.append(",");

				//writer.append(String.valueOf(ee.getInvoiceid()));
	      		writer.append(ee.getInvoiceid());
	      		writer.append(",");

				//writer.append(String.valueOf(ee.getDateandtime()));
	      		writer.append(ee.getSettlementdate());
	      		writer.append(",");
	      		
	      		writer.append(ee.getSettletype());
	      		writer.append(",");
	      		
	      		writer.append(ee.getMdramt());
	      		writer.append(",");
	      		
	      		writer.append(ee.getCardbrand());
	      		writer.append(",");
	      		
	      		writer.append(ee.getCardcurr());
	      		writer.append(",");
	      		
	      		writer.append(ee.getCardtype());
	      		writer.append(",");
	      		
	      		writer.append(ee.getDate());
	      		writer.append(",");
	      		
	      		writer.append("\n");

                
				//p.write(sb.toString());
			
		 }
		writer.flush();
		 writer.close();
		
	
		//p.close();
		}
		catch(Exception e) {
			
			System.out.println(e);
			
		}
		write w =new write();
//		w.sendEmail("C:\\Mobi_config\\toyyibpaycsv\\toyyibpaycsv.csv");
		w.sendEmail(filename);
		//w.sendEmail	("C:\\Users\\hp\\Desktop\\writee.csv");
		}

	public void sendEmail(String filename){
		
		
		String fromAddress = ExCommons.getFile().getProperty("FROMMAIL");
		//String apiKey = "c652b570-9500-4534-8eb6-96a78c10c8b8";
		String apiKey = ExCommons.getFile().getProperty("APIKEY");
		
        String toAddress =ExCommons.getFile().getProperty("MAIL_TO");
        String ccAddress = ExCommons.getFile().getProperty("MAIL_CC");
        String subject = ExCommons.getFile().getProperty("SUBJECT");
		//String emailBody = ExCommons.getFile().getProperty("EMAILBODY")+"  "+new SimpleDateFormat("dd-MM-yyyy").format(new Date(System.currentTimeMillis()-24*60*60*1000));//set
		String emailBody = ExCommons.getFile().getProperty("EMAILBODY")+"  "+ExCommons.getFile().getProperty("DATE");


		String path ="C:\\Mobi_config\\toyyibpaycsv\\";
		String patteren=".csv";		
		Attachment fileAttach = null;
		try{
			
			
			String fileName =filename;
			 fileAttach = new Attachment(
					fileName,
					"application/csv",
					encodeFileToBase64Binary(path+filename),
					"cid:"+fileName);
		}catch(Exception e){
			
		}
		
		
		List<Attachment> attachments = new ArrayList<Attachment>();
		attachments.add(fileAttach);
	

		PostmarkMessage message = new PostmarkMessage(fromAddress, toAddress,
				fromAddress, ccAddress, subject, emailBody, true, "test-email",
				null, attachments);
		PostmarkClient client = new PostmarkClient(apiKey);
		try {
			client.sendMessage(message);
		} catch (CSV.writeread.PostmarkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	}
	 public static String encodeFileToBase64Binary(String fileName)
				throws IOException {

			File file = new File(fileName);
			byte[] bytes = loadFile(file);
			byte[] encoded = Base64.encodeBase64(bytes);
			String encodedString = new String(encoded);

			return encodedString;
		}
	 private static byte[] loadFile(File file) throws IOException {
		    InputStream is = new FileInputStream(file);

		    //long length = file.length();
		   /* if (length > Integer.MAX_VALUE) {
		        // File is too large
		    }*/
		    byte[] bytes = new byte[(int)file.length()];
		    
		    int offset = 0;
		    int numRead = 0;
		    while (offset < bytes.length
		           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
		        offset += numRead;
		    }

		    /*if (offset < bytes.length) {
		        throw new IOException("Could not completely read file "+file.getName());
		    }*/

		    is.close();
		    return bytes;
		}
	
		}
