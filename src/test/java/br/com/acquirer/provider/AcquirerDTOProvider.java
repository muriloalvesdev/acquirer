package br.com.acquirer.provider;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import br.com.acquirer.ConstantsTests;
import br.com.acquirer.dto.AcquirerDataTransferObject;

public class AcquirerDTOProvider implements ArgumentsProvider, ConstantsTests {
  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
    return Stream.of(new AcquirerDataTransferObject(CIELO.name(), CNPJ_CIELO)).map(Arguments::of);
  }
}
