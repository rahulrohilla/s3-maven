package s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;

import java.io.File;

public class FolderUpload {

    public static void main(String[] args) {

        TransferManager trf_mgr = new TransferManager();

        String dir_path="/Users/rahulrohilla/express-demo";
        String key_prefix = "ss";
        String bucket_name= "CreateBucket";

        boolean recursive = false;
        MultipleFileUpload trf = trf_mgr.uploadDirectory(bucket_name,key_prefix,new File(dir_path),recursive);

        try{

            trf.waitForCompletion();

        }catch (AmazonServiceException e){

            System.err.println("Amazon Service Error " + e.getMessage());
            System.exit(1);


        }catch (AmazonClientException e){

            System.out.println("Amazon Service Exception"  + e.getMessage());
            System.exit(1);


        }catch (InterruptedException e){

            System.out.println("Transfer Interrupted"  + e.getMessage());
            System.exit(1);

        }

        trf_mgr.shutdownNow();


    }
}
