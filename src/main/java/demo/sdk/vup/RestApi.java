package demo.sdk.vup;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.equifax.dto.purposing.v1.sdk.model.VupOut;
import ar.efx.vup.sdk.purposing.v1.controller.Ivup;
import ar.efx.vup.sdk.purposing.v1.exception.VupExceptionError;
import ar.efx.vup.sdk.purposing.v1.exception.VupExceptionIllegalArgument;
import ar.efx.vup.sdk.purposing.v1.exception.VupExceptionNOTFOUND;
import ar.efx.vup.sdk.purposing.v1.exception.VupExceptionUNAUTHORIZED;
import ar.efx.vup.sdk.purposing.v1.model.ParamPurposing;

@RestController
@RequestMapping("/api")
public class RestApi {

    @Autowired
    public Ivup vup;


    @GetMapping("sdk")
    public String getSDK() {
        // http://localhost:8080/api/sdk

        Set<String> ar = new HashSet<String>();

        ar.add("PURP_CREDIT_CONSCOM");

        String Token = "token";

        VupOut vupOb = null;
        try {


            ParamPurposing vp = new ParamPurposing();
            vp.setPurposign(ar);
            vp.setEntityKey(1L);
            vp.setToKen(Token);


            vupOb = vup.exeVup(vp);


            vupOb.getObraSocial().stream().map(p -> p.getPeriodo())
                    .forEach(System.out::println);



        } catch (VupExceptionError ex) {
            //
        } catch (VupExceptionUNAUTHORIZED ex) {
            //
        } catch (VupExceptionIllegalArgument ex) {
            //
        } catch (VupExceptionNOTFOUND ex) {
            //
        }


        return "Test Succes";
    }


}
