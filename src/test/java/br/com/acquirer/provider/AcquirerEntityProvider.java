package br.com.acquirer.provider;

import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import br.com.acquirer.ConstantsTests;
import br.com.acquirer.domain.model.Acquirer;

public class AcquirerEntityProvider implements ArgumentsProvider, ConstantsTests {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
    return Stream.of(
        Acquirer.newBuilder().acquirerName(CIELO).cnpj(CNPJ_CIELO).uuid(UUID.randomUUID()).build())
        .map(Arguments::of);
  }

}
