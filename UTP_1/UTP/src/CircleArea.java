public class CircleArea implements IAggregable<CircleArea, Double>, IDeeplyCloneable<CircleArea> {
    private Double _radius;

    public CircleArea(){}
    public CircleArea(Double side){
        _radius = side;
    }
    public Double get_radius(){
        return _radius;
    }

    public Double aggregate(Double intermediateResult){
        if(intermediateResult == null){
            return _radius;
        }else{
            return Math.pow(intermediateResult, 2)*Math.PI;
        }
    }
    public CircleArea deepClone(){
        CircleArea sq1 = new CircleArea();
        sq1._radius = _radius;
        return sq1;
    }


}
