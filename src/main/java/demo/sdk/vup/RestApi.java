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
@RequestMapping("/api/vup")
public class RestApi {

    @Autowired
    public Ivup vup;


    public final String token =

            "eyJhbGciOiJSUzI1NiIsImtpZCI6InBpbmdzc28yMDIyMDUiLCJ4NXQiOiIycTlYWllqYklldjNBV0N1b3NUMUNfbGtNSmsiLCJwaS5hdG0iOiIxIn0.eyJzY29wZSI6WyJvcGVuaWQiLCJwcm9maWxlIiwiZ3JvdXBzIl0sImNsaWVudF9pZCI6ImRhdGFmYWJyaWNfdXNfcGxhdGZvcm1faWMiLCJpc3MiOiJodHRwczovL2ZlZHNzby5lcXVpZmF4LmNvbSIsImp0aSI6IkpWWHVoblBGdkxIalhNakIiLCJzdWIiOiJseGExNDUiLCJleHAiOjE2MDkxNjc1MDl9.mFcUS6w5TM1diPVeJf1o1hsCNNn_3Ig16eXrQO1QKbwTw98mKxacovEc42-BaX7Vi9toKS5A5oojfXF_3UtzGVmOyuheJSIM2U3w5Oywdrn-GuGXWeO2xS7SuPCmyvSyIQduec3F96wluJfjRD49vzcc66776tDeKg5-eGmZPSrlXsjLGgmd3xJ-nrbESvIZ_JUECsAA9GBUxK71f45S4NLF30uanRGzt4eIwwZvqdWQGHhkPW2W7xlXC1OlTLemtCF5tADMp40rkIc6Mo7CTr1ZMXmiD8jll4or0FRQ8gRoVrJMyQCk8kH8nu4G8gE23oAJEilCH7voFzdN3Q-YMA";

    // http://localhost:8080/api/vup/sdkiup

    @GetMapping("sdkiup")
    public VupOut getSDK() {
        // http://localhost:8080/api/sdk

        Set<String> ar = new HashSet<String>();

        ar.add("PURP_CREDIT_CONSCOM");

        VupOut vupOb = null;
        try {


            ParamPurposing vp = new ParamPurposing();
            vp.setPurposign(ar);
            vp.setEntityKey(2980645L);
            vp.setToKen(token);


            vupOb = vup.exeVup(vp);


            vupOb.getObraSocial().stream().map(p -> p.getPeriodo())
                    .forEach(System.out::println);

            return vupOb;

        } catch (VupExceptionError ex) {
            //
        } catch (VupExceptionUNAUTHORIZED ex) {
            //
        } catch (VupExceptionIllegalArgument ex) {
            //
        } catch (VupExceptionNOTFOUND ex) {
            //
        }


        return null;
    }


}
