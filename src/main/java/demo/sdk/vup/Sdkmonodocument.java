package demo.sdk.vup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.equifax.dto.purposing.v1.sdk.model.VupSdkDataReact;
import ar.efx.vup.sdk.purposing.v1.controller.Ivup;
import ar.efx.vup.sdk.purposing.v1.exception.VupExceptionNOTFOUND;
import ar.efx.vup.sdk.purposing.v1.model.ParamIupSourcesDocument;
import ar.efx.vup.sdk.purposing.v1.model.ParamReactDocument;
import ar.efx.vup.sdk.purposing.v1.model.ParamReactSdkDocument;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/vup")
public class Sdkmonodocument {


    @Autowired
    public Ivup vup;


    public final String token =

            "eyJhbGciOiJSUzI1NiIsImtpZCI6InBpbmdzc28yMDIyMDUiLCJ4NXQiOiIycTlYWllqYklldjNBV0N1b3NUMUNfbGtNSmsiLCJwaS5hdG0iOiIxIn0.eyJzY29wZSI6WyJvcGVuaWQiLCJwcm9maWxlIiwiZ3JvdXBzIl0sImNsaWVudF9pZCI6ImRhdGFmYWJyaWNfdXNfcGxhdGZvcm1faWMiLCJpc3MiOiJodHRwczovL2ZlZHNzby5lcXVpZmF4LmNvbSIsImp0aSI6IkpWWHVoblBGdkxIalhNakIiLCJzdWIiOiJseGExNDUiLCJleHAiOjE2MDkxNjc1MDl9.mFcUS6w5TM1diPVeJf1o1hsCNNn_3Ig16eXrQO1QKbwTw98mKxacovEc42-BaX7Vi9toKS5A5oojfXF_3UtzGVmOyuheJSIM2U3w5Oywdrn-GuGXWeO2xS7SuPCmyvSyIQduec3F96wluJfjRD49vzcc66776tDeKg5-eGmZPSrlXsjLGgmd3xJ-nrbESvIZ_JUECsAA9GBUxK71f45S4NLF30uanRGzt4eIwwZvqdWQGHhkPW2W7xlXC1OlTLemtCF5tADMp40rkIc6Mo7CTr1ZMXmiD8jll4or0FRQ8gRoVrJMyQCk8kH8nu4G8gE23oAJEilCH7voFzdN3Q-YMA";

    // http://localhost:8080/api/vup/sdkmonodocument

    @GetMapping("sdkmonodocument")
    public Mono<VupSdkDataReact> getSDKMonoSdocument()
            throws VupExceptionNOTFOUND {



        List<ParamIupSourcesDocument> vupEntry =
                new ArrayList<ParamIupSourcesDocument>();


        /* ***************** */
        Set<String> purposign = new HashSet<String>();
        purposign.add("PURP_CREDIT_CONSCOM");

        ParamIupSourcesDocument pai = new ParamIupSourcesDocument();
        pai.setNumero("20237979800");
        pai.setTipo("CUIT");
        pai.setPurposign(purposign);

        vupEntry.add(pai);

        ParamReactDocument paramd = new ParamReactDocument();
        paramd.setVupEntry(vupEntry);

        ParamReactSdkDocument param = new ParamReactSdkDocument(paramd, token);


        return vup.MonoVupReactDocument(param);


    }


}
