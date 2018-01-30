package nl.rce.uv.dpu;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import eu.unifiedviews.dpu.config.DPUConfigException;
import eu.unifiedviews.helpers.dpu.vaadin.dialog.AbstractDialog;

/**
 * Vaadin configuration dialog for RdfToWeb.
 *
 * @author Unknown
 */
public class RdfToWebVaadinDialog extends AbstractDialog<RdfToWebConfig_V1> {

    public RdfToWebVaadinDialog() {
        super(RdfToWeb.class);
    }

    @Override
    public void setConfiguration(RdfToWebConfig_V1 c) throws DPUConfigException {

    }

    @Override
    public RdfToWebConfig_V1 getConfiguration() throws DPUConfigException {
        final RdfToWebConfig_V1 c = new RdfToWebConfig_V1();

        return c;
    }

    @Override
    public void buildDialogLayout() {
        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setWidth("100%");
        mainLayout.setHeight("-1px");
        mainLayout.setMargin(true);

        mainLayout.addComponent(new Label(ctx.tr("RdfToWeb.dialog.label")));

        setCompositionRoot(mainLayout);
    }
}
