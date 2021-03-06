package uk.org.tombolo.importer.dclg;

import uk.org.tombolo.core.Provider;
import uk.org.tombolo.importer.AbstractImporter;
import uk.org.tombolo.importer.Config;

public abstract class AbstractDCLGImporter extends AbstractImporter {
    public static final Provider PROVIDER
            = new Provider("uk.gov.dclg", "Department for Communities and Local Government");

    public AbstractDCLGImporter(Config config) {
        super(config);
    }

    @Override
    public Provider getProvider() {
        return PROVIDER;
    }

}
