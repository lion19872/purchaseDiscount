fun calculateDiscount(purchaseAmount: Int, isRegularCustomer: Boolean): Int {
    var discountAmount = 0

    when {
        purchaseAmount in 1_001..10_000 -> discountAmount = 100
        purchaseAmount >= 10_001 -> discountAmount = (purchaseAmount * 0.05).toInt()
    }

    if (isRegularCustomer) {
        discountAmount += (purchaseAmount * 0.01).toInt()
    }

    return purchaseAmount - discountAmount
}

fun main() {
    print("Введите сумму покупки в рублях: ")
    val purchaseAmountInput = readLine()
    val purchaseAmount = purchaseAmountInput?.toIntOrNull() ?: 0

    print("Являетесь ли вы постоянным покупателем (да/нет): ")
    val isRegularCustomerInput = readLine()
    val isRegularCustomer = isRegularCustomerInput?.equals("да", ignoreCase = true) ?: false

    val finalAmount = calculateDiscount(purchaseAmount, isRegularCustomer)
    println("Итоговая сумма с учетом скидки: $finalAmount руб.")
}
