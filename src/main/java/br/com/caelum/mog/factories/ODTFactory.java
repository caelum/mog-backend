package br.com.caelum.mog.factories;

import br.com.caelum.mog.adapters.Downloadable;
import br.com.caelum.mog.domains.models.Offer;
import br.com.caelum.mog.exceptions.OfferODTException;
import br.com.caelum.mog.infra.TemplateResolver;
import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.annotation.RequestScope;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

@Component
@RequestScope
public class ODTFactory {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_hhmm");
    private final TemplateResolver resolver;

    public ODTFactory(TemplateResolver resolver) {

        this.resolver = resolver;
    }

    public Downloadable create(Offer offer) {

        Assert.notNull(offer, "Offer required");

        Supplier<String> lazinessFilename = () -> offer.getCustomer().getCommercialName()
                                                    + "-"
                                                    + LocalDateTime.now().format(formatter) + ".odt";
        try {
            DocumentTemplateFactory templateFactory = new DocumentTemplateFactory();

            InputStream templateFile = resolver.getCurrentTemplate();

            DocumentTemplate template = templateFactory.getTemplate(templateFile);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            template.createDocument(offer, outputStream);

            return new Downloadable(outputStream.toByteArray(), lazinessFilename);

        } catch (DocumentTemplateException | IOException e) {
            throw new OfferODTException(e);
        }

    }


}
