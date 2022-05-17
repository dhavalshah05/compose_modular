sealed class FeatureTab {
    abstract val title: String
    abstract val hasData: Boolean
    abstract val showRedIndicator: Boolean
}

data class SaverTab(
    override val title: String,
    override val hasData: Boolean,
    override val showRedIndicator: Boolean,
) : FeatureTab()

data class SaversTab(
    override val title: String,
    override val hasData: Boolean,
    override val showRedIndicator: Boolean,
) : FeatureTab()

data class LatestTab(
    override val title: String,
    override val hasData: Boolean,
) : FeatureTab() {
    override val showRedIndicator: Boolean
        get() = false
}

data class ShoppingListTab(
    override val title: String,
    override val hasData: Boolean,
) : FeatureTab() {
    override val showRedIndicator: Boolean
        get() = false
}

data class ShopTab(
    override val title: String,
    override val hasData: Boolean,
) : FeatureTab() {
    override val showRedIndicator: Boolean
        get() = false
}

object FeatureTabs {
    fun get(): List<FeatureTab> {
        return listOf<FeatureTab>(
            SaverTab(title = "KYL", hasData = true, showRedIndicator = false),
            SaverTab(title = "FRYS", hasData = true, showRedIndicator = false),
            SaversTab(title = "Saver", hasData = false, showRedIndicator = false),
            LatestTab(title = "Latest", hasData = true),
            ShoppingListTab(title = "All", hasData = false),
            ShopTab(title = "Ica Maxi", hasData = true),
            ShopTab(title = "Reliance", hasData = true),
        )
    }
}