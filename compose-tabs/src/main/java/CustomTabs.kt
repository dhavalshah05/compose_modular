import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Preview
@Composable
private fun CustomTabsPreview() {
    CustomTabs(
        selectedTabIndex = 0,
        featureTabs = FeatureTabs.get(),
        onTabSelect = {}
    )
}

@Composable
fun CustomTabs(
    selectedTabIndex: Int,
    featureTabs: List<FeatureTab>,
    onTabSelect: (FeatureTab) -> Unit
) {
    val colorBackground = Color(0xFFFFF0F0)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = colorBackground,
            contentColor = Color.Black,
            edgePadding = 0.dp,
            tabs = {
                for (featureTab in featureTabs) {
                    val isFeatureTabSelected = featureTabs.indexOf(featureTab) == selectedTabIndex

                    Tab(
                        selected = isFeatureTabSelected,
                        onClick = { onTabSelect(featureTab) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black,
                    ) {
                        val textColor = if (isFeatureTabSelected) {
                            Color.White
                        } else if (!featureTab.hasData) {
                            Color.Gray
                        } else {
                            Color.Black
                        }
                        val fontWeight = if (isFeatureTabSelected) {
                            FontWeight.Bold
                        } else {
                            FontWeight.Light
                        }
                        Text(
                            featureTab.title.uppercase(),
                            modifier = Modifier.padding(vertical = 12.dp),
                            color = textColor,
                            fontWeight = fontWeight
                        )
                    }
                }
            },
            indicator = { tabPositions ->
                val tabPosition = tabPositions[selectedTabIndex]
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPosition)
                        .zIndex(-1f)
                        .padding(vertical = 4.dp, horizontal = 2.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxHeight(),
                )
            },
            divider = {}
        )

    }
}
