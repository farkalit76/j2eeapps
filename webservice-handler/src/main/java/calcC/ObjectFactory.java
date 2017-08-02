
package calcC;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the calcC package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindSymbolResponse_QNAME = new QName("http://chapter3.webreading.farkalit.com/calc", "findSymbolResponse");
    private final static QName _Operation_QNAME = new QName("http://chapter3.webreading.farkalit.com/calc", "operation");
    private final static QName _FindSymbol_QNAME = new QName("http://chapter3.webreading.farkalit.com/calc", "findSymbol");
    private final static QName _OperationResponse_QNAME = new QName("http://chapter3.webreading.farkalit.com/calc", "operationResponse");
    private final static QName _CalcException_QNAME = new QName("http://chapter3.webreading.farkalit.com/calc", "CalcException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calcC
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindSymbol }
     * 
     */
    public FindSymbol createFindSymbol() {
        return new FindSymbol();
    }

    /**
     * Create an instance of {@link CalcException }
     * 
     */
    public CalcException createCalcException() {
        return new CalcException();
    }

    /**
     * Create an instance of {@link OperationResponse }
     * 
     */
    public OperationResponse createOperationResponse() {
        return new OperationResponse();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link FindSymbolResponse }
     * 
     */
    public FindSymbolResponse createFindSymbolResponse() {
        return new FindSymbolResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSymbolResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter3.webreading.farkalit.com/calc", name = "findSymbolResponse")
    public JAXBElement<FindSymbolResponse> createFindSymbolResponse(FindSymbolResponse value) {
        return new JAXBElement<FindSymbolResponse>(_FindSymbolResponse_QNAME, FindSymbolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter3.webreading.farkalit.com/calc", name = "operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindSymbol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter3.webreading.farkalit.com/calc", name = "findSymbol")
    public JAXBElement<FindSymbol> createFindSymbol(FindSymbol value) {
        return new JAXBElement<FindSymbol>(_FindSymbol_QNAME, FindSymbol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter3.webreading.farkalit.com/calc", name = "operationResponse")
    public JAXBElement<OperationResponse> createOperationResponse(OperationResponse value) {
        return new JAXBElement<OperationResponse>(_OperationResponse_QNAME, OperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalcException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://chapter3.webreading.farkalit.com/calc", name = "CalcException")
    public JAXBElement<CalcException> createCalcException(CalcException value) {
        return new JAXBElement<CalcException>(_CalcException_QNAME, CalcException.class, null, value);
    }

}
