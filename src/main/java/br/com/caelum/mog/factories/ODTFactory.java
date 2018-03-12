package br.com.caelum.mog.factories;

import br.com.caelum.mog.adapters.Downloadable;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.exceptions.OfferODTException;
import br.com.caelum.mog.infra.TemplateResolver;
import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

@Component
public class ODTFactory {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_hhmm");
    private File templateFile;

    public ODTFactory(TemplateResolver resolver) {
        this.templateFile = resolver.getCurrentTemplate();
    }

    public Downloadable create(Offer offer) {

        Supplier<String> lazinessFilename = () -> offer.getCustomer().getCommercialName()
                                                    + "-"
                                                    + LocalDateTime.now().format(formatter) + ".odt";
        try {
            DocumentTemplateFactory templateFactory = new DocumentTemplateFactory();

            DocumentTemplate template = templateFactory.getTemplate(templateFile);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            template.createDocument(offer, outputStream);

            return new Downloadable(outputStream.toByteArray(), lazinessFilename);

        } catch (DocumentTemplateException | IOException e) {
            throw new OfferODTException(e);
        }

    }


}
