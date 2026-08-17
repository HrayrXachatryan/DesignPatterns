data class Order(val weightKg: Double, val distanceKm: Double)

interface  DeliveryStrategy{
    fun calculateCost(order: Order): Double
}

class StandardDelivery : DeliveryStrategy{
    override fun calculateCost(order: Order): Double = order.distanceKm * 100 + order.weightKg * 50
}

class ExpressDelivery : DeliveryStrategy{
    override fun calculateCost(order: Order): Double = (order.distanceKm * 100 + order.weightKg * 50) * 1.5
}

class FreeDelivery : DeliveryStrategy{
    override fun calculateCost(order: Order): Double = 0.0
}

class DeliveryCalculator(private var strategy: DeliveryStrategy){
    fun setStrategy(strategy: DeliveryStrategy){
        this.strategy = strategy
    }
    fun calculate(order: Order): Double{
        return strategy.calculateCost(order)
    }
}


