package ec.gob.sri.comprobantes.util.key;

import java.security.KeyStore;
import java.security.KeyStoreException;

public abstract interface KeyStoreProvider
{
  public abstract KeyStore getKeystore(char[] paramArrayOfChar)
    throws KeyStoreException;
}


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.KeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */