import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Container<ElementType extends  IAggregable<ElementType, AggregateElem> & IDeeplyCloneable<ElementType>, AggregateElem>
        implements IContainer<ElementType, AggregateElem>{
    private List<ElementType> _element;

    public Container(){
    }
    public Container(ElementType[] element){
        _element = Arrays.asList(element);
    }
    @Override
    public List<ElementType> element(){
        if(_element == null){
            return new ArrayList<>(null);
        }
        return _element;
    }
    @Override
    public ElementType cloneElementAtIndex(int index) {
        if (_element == null || index >= _element.size() || index < 0) {
            System.out.println("You're outta here");
            return null;
        }
        return _element.get(index).deepClone();
    }

    @Override
    public AggregateElem aggregateAllElements(){
        if(_element == null){
            return null;
        }
        AggregateElem result = null;
        for(ElementType elementType : _element ){
            result = elementType.aggregate(result);
        }
        return result;
    }


}
