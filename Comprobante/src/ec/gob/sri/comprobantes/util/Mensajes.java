package ec.gob.sri.comprobantes.util;

public class Mensajes
{
  public static final String NO_PERMITIDOS_EN_VALORES = "`~!@#$%^&*()_+=\\|\"':;?/><, -";
  public static final String NO_PERMITIDOS_EN_NUMEROS = "`~!@#$%^&*()_+=\\|\"':;?/>.<, -";
  public static final String SOLO_VALORES = "Solo se permiten valores numéricos";
  public static final String SOLO_NUMEROS = "Solo se permiten números";
  public static final String ERROR_VALOR = "Valor no permitido";
  public static final String SOLO_UN_SEPARADOR = "La cantidad ingresada no puede tener mas de un (.) decimal";
  public static final String LONGITUD_MAXIMA = "La longitud máxima del campo ha sido alcanzada: ";
  public static final String VALOR_EXEDE_CONSUMIDOR_FINAL = "No se pueden emitir facturas mayores a USD 200.00 donde el comprador conste como: CONSUMIDOR FINAL";
  public static final String VALOR_EXEDE_PROPINA = "El valor ingresado en el campo Propina exede o es menor al 10% del Subtotal ";
  public static final String ITEM_YA_EXISTE = "El ítem seleccionado ya se encuentra en el detalle de la Factura, favor modifique su cantidad";
  public static final String TAM_GUIA_REMISION = "Guía de Remisión debe ser de 15 números: ej: 123-123-123456789";
  public static final String CAMPOS_OBLIGATORIOS = "Ingrese los campos obligatorios del comprobante";
  public static final String LIMITE_5 = "So puede ingresar hasta cinco detalles adicionales";
  public static final String LIMITE_DECIMAL = "El número máximo de decimales permitido es: ";
  public static final String NOTADEDEBITO_VACIA = "Ingrese los valores correspondientes a la Nota de Débito";
  public static final String COMPROBANTE_VACIO = "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas";
  public static final String GUIA_VACIO = "Al menos debe añadir un DESTINATARIO en la Guía de Remisión";
  public static final String INGRESE_NO_COMPROBANTE = "\nIngrese el número de comprobante a modificar";
  public static final String INGRESE_NO_AUTORIZACION = "Ingrese el número de autorización del comprobante a modificar";
  public static final String INGRESE_FECHA = "\nIngrese la fecha de emisión del comprobante a modificar";
  public static final String INGRESE_ID = "Ingrese el RUC /CI o pasaporte o la Razón Social";
  public static final String FECHA_MAYOR = "No se permiten fechas mayores a la del día de hoy";
  public static final String FECHA_MENOR = "No se permiten fechas menores a la del día de hoy";
  public static final String FECHA_ERROR = "La fecha del Comprobante de Retención no puede ser menor a la fecha de emisión del Documento de Sustento";
  public static final String CLAVE_ACCESO = "\nLa clave de Acceso no puede ser nula";
  public static final String ERROR_IMPUESTO_PROD = "El producto seleccionado, no tiene asignado ningun impuesto,\nfavor edite el producto e ingrese los impuestos";
  public static final String INGRESE_MOTIVO = "\nIngrese el motivo de modificación  del comprobante";
  public static final String CALCULAR_TOTAL = "\nNo se ha calculado el Valor Total del comprobante";
  public static final String CODIGO_ICE_NO_EXISTE = "El código de ICE ingresado no se encuentra registrado";
  public static final String INGRESE_CODIGO_ICE = "Ingrese el código ICE correspondiente al impuesto";
  public static final String PERIODO_FISCAL = "\nEl mes y el año del período fiscal son obligatorios";
  public static final String ANIO_PERIODO_FISCAL = "\nEl año del período fiscal no puede ser mayor actual";
  public static final String SUJETO_RETENCION = "\nLos datos de Sujeto Retenido son obligatorios";
  public static final String PERIODO_FISCAL_MAYOR = "\nEl período fiscal no puede ser mayor a la fecha actual";
  public static final String COD_DOC_TAMANIO = "\n El Nro. del Comprobante debe de ser de 15 dígitos";
  public static final String INGRESE_DIREC_PARTIDA = "\nIngrese la dirección de partida del transportista";
  public static final String INGRESE_FECHA_FIN = "\nIngrese la fecha de fin del transporte";
  public static final String INGRESE_FECHA_INICIO = "\nIngrese la fecha de inicio del transporte";
  public static final String SELECCION_TRANS = "\nSeleccione un Transportista";
  public static final String INGRESE_COD_DOC = "\nIngrese el Código del Documento al que se refiere la opción OTROS";
  public static final String NUM_AUT_COD_DOC = "\n El Nro. de Autorización del comprobante debe de ser de 10 o 37 dígitos";
  public static final String FEC_EMI_COD_DOC = "\n Ingrese la Fecha de Emisión del Documento de Sustento";
  public static final String INGRESE_DIR_DEST = "\n Ingrese la Dirección de Destino";
  public static final String INGRESE_MOT_TRAS = "\n Ingrese el Motivo de Traslado";
  public static final String INGRESE_TAM_NUM_DOC = "\n El Nro. de comprobante debe de ser de 15 caracteres";
  public static final String NJRO_COMPROBANTE_OBLIGATORIO = "\nEl número de comprobante es obligatorio y debe ser de 15 caracteres";
  public static final String CONDIC_ADD_DESTINT = "Debe seleccionar un Transportista, un Destinatario y debe añadir al menos un Producto al detalle ";
  public static final String FECHA_MAYOR_INI = "La fecha de fin de transporte  no puede ser anterior a la fecha de inicio";
  public static final String NO_ENCONTRADO = "No existen registros almacenados para el dato buscado";
  public static final String NO_EXISTE_CERTIFICADO = "No se encontró un certificado válido o autorizado para firma electrónica";
  public static final String CERTIFICADO_NO_VALIDO = "El certificado no es válido";
  public static final String CERTIFICADO_EXPIRADO = "El certificado se encuentra expirado, favor contacte al emisor";
  public static final String SISTEMA_OPERATIVO_NO_COMPATIBLE = "El aplicativo actualmente solo soporta Sistemas Operativos basados en Windows";
  public static final String ERROR_ENVIO_COMPROBANTE = "Error al momento de enviar el comprobante";
  public static final String ERROR_RESPUESTA_COMPROBANTE = "Error al enviar el comprobante estado : %s \nRevisar la carpeta de rechazados";
  public static final String ERROR_VALIDACION_COMPROBANTE_NO_AUTORIZADO = "Error al validar el comprobante estado : %s \n%s";
  public static final String ERROR_VALIDACION_COMPROBANTE = "Error al validar el comprobante estado : %s \n";
  public static final String ERROR_TAMANIO_LOTE = "El tamaño del lote exede el límite permitido (500 Kbytes)";
  public static final String ERROR_ENVIO_LOTE = "Se ha producido un error al enviar el lote";
  public static final String SELECCIONE_ARCHIVOS = "Seleccione al menos un archivo";
  public static final String ARCHIVO_GUARDADO = "El comprobante fue guardado exitósamente";
  public static final String ARCHIVO_FIRMADO = "El comprobante fue firmado exitósamente";
  public static final String ARCHIVO_GUARDADO_FIRMADO = "El comprobante fue guardado, firmado y enviado exitósamente, pero no fue Autorizado";
  public static final String ARCHIVO_AUTORIZADO = "El comprobante fue autorizado por el SRI";
  public static final String ARCHIVO_ENVIADO = "El comprobante fue enviado, está pendiente de autorización";
  public static final String ARCHIVO_SIN_RESPUESTA = "El archivo no tiene autorizaciones relacionadas";
  public static final String ARCHIVO_NO_PROCESADO = "NO PROCESADO";
  public static final String ERROR = "Se ha producido un error ";
  public static final String ERROR_FIRMAR = "Error al tratar de firmar digitalmente el archivo";
  public static final String ERROR_CREAR = "Error al tratar de crear el archivo correspondiente al comprobante";
  public static final String ERROR_ENVIAR = "Error al tratar de enviar el comprobante hacia el SRI";
  public static final String ERROR_AUTORIZAR = "Error al tratar de autorizar el comprobante por el SRI";
  public static final String ERROR_MOVER_DIRECTORIO_RECHAZADOS = "Error al mover el archivo a la carpeta rechazados";
  public static final String ERROR_MOVER_DIRECTORIO_ENVIADOS = "Error al mover el archivo a la carpeta enviados";
  public static final String ERROR_TRANSMITIDO = "Ha ocurrido un error en el proceso de la Autorización, por lo que se traslado el archivo a la carpeta de: transmitidosSinRespuesta";
  public static final String ERROR_MOVER_TRANSM = "\nError al mover el archivo a la carpeta de Transmitidos sin Respuesta";
  public static final String ERROR_MOVER_DIRECTORIO = "Error al mover el archivo al directorio: %s";
  public static final String X509_SO = "Sistema operativo o JRE no compatible los los tokens de firma";
  public static final String X509_FIRMA_INVALIDA = "Se ha producido un error al momento de crear \nla firma del comprobante electrónico, ya que el la firma digital no es válida";
  public static final String X509_CERT_NO_RUC = "El certificado digital proporcionado no posee los datos de RUC OID: 1.3.6.1.4.1.37XXX.3.11,\nrazón por la cual usted no podrá firmar digitalmente documentos para remitir al SRI,\nfavor actualize su certificado digital con la Autoridad Certificadora";
  public static final String X509_RUC_NO_COINCIDE_CERT = "El Ruc presente en el certificado digital, no coincide con el Ruc registrado en el aplicativo";
  public static final String X509_CERT_NO_PRESENTE = "No se pudo encontrar un certificado válido para firmar el archivo";
  public static final String X509_CERT_EXPIRADO = "El certificado con el que intenta firmar el comprobante esta expirado\nfavor actualize su certificado digital con la Autoridad Certificadora";
  public static final String X509_XML_INVALIDO = "Archivo XML a firmar mal definido o estructurado";
  public static final String X509_CLAVE_PRIVADA = "No se pudo acceder a la clave privada del certificado";
  public static final String CLAVES_CONTIGENCIA = "No existen claves de contingencia, por favor cargue claves en el Sistema o cambie su estado de Emisión a: NORMAL";
  public static final String INDISPONIBILIDAD_OSCP = "INTENTE NUEVAMENTE EN MINUTOS";
  public static final String CONSUMIDOR_FINAL = "CONSUMIDOR FINAL";
  public static final String SELECT_OPTION = "escoja...";
  public static final String ELIMINAR = "Eliminar";
  public static final String OPCION_NO = "NO";
  public static final String OPCION_SI = "SI";
  public static final String MONEDA = "DOLAR";
  public static final String NO_EXISTE_DIRECTORIO = "Verifique si está registrado el directorio : %s";
  public static final String ERROR_DIRECTORIO = "Se produjo un error al consultar el direcotorio : %s";
  public static final String ERROR_SQL_ACTUALIZAR_SECUENCIAL = "Se produjo un error al actualizar el secuencial";
  public static final String ERROR_MERGE_RESPUESTA = "Se produjo un error al adjuntar los resultados de la respuesta al comprobante enviado";
  public static final String ERROR_CONVETIR_XML = "Se produjo un error al convetir el archivo al formato XML";
  public static final String FIRMA_VALIDA = "FIRMA VALIDA";
  public static final String FIRMA_INVALIDA = "FIRMA INVALIDA";
  public static final String ERROR_LONGITUD_CEDULA = "El número de cédula ser igual a 10 caracteres numericos";
  public static final String ERROR_LONGITUD_RUC = "El número de RUC ser igual a 13 caracteres numéricos y debe terminar en 001";
  public static final String ERROR_LONGITUD_PASAPORTE = "El número de pasaporte ser igual a 13 caracteres.";
  public static final String ERROR_LONGITUD_IDENTIFICACION_EXTERIOR = "El número de identificación del exterior debe ser menor o igual a 20 caracteres.";
  public static final String ERROR_LONGITUD_PLACA = "El número de placa debe ser menor o igual a 13 caracteres.";
  public static final String ERROR_VALOR_TOTAL_FACTURA_CERO = "El valor total de la factura no puede ser menor ha 0";
}


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.Mensajes
 * JD-Core Version:    0.7.0.1
 */