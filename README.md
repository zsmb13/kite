<p align="center">
  <a href="https://github.com/cioccarellia/kite" target="_blank"><img width="100" src="art/icon.png"></a>
</p>
<h1 align="center">Kite</h1>
<p align="center">Android Resource Wrapper Library.</p>
<p align="center">
  <a href="https://bintray.com/cioccarellia/maven/kite/_latestVersion"><img src="https://api.bintray.com/packages/cioccarellia/maven/kite/images/download.svg" alt="Download from Bintray"></a>
  <a href="https://app.circleci.com/pipelines/github/cioccarellia/kite"><img src="https://circleci.com/gh/cioccarellia/kite.svg?style=svg" alt="CircleCI"></a>
  <a href="https://www.codacy.com/gh/cioccarellia/kite/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=cioccarellia/kite&amp;utm_campaign=Badge_Grade"><img src="https://app.codacy.com/project/badge/Grade/91fb67a5494d4767b71c7bf99810c1c9" alt="Codacy"></a>
  <a><img src="https://img.shields.io/badge/kotlin-1.4.10-orange.svg" alt="Kotlin"></a>
  <a><img src="https://img.shields.io/badge/min-14-00e676.svg" alt="Android Min Sdk"></a>
  <a><img src="https://img.shields.io/badge/compile-30-00e676.svg" alt="Android Compile Version"></a>
  <a href="https://github.com/cioccarellia/kite/blob/master/LICENSE"><img src="https://img.shields.io/badge/license-Apache%202.0-blue.svg" alt="License"></a>
</p>

## TLDR
Fed up with typing `ContextCompact`, `recources` and `context` all over your apps to access your resources? Say no more.
```gradle
implementation 'com.cioccarellia:kite:1.0.0-beta1'
```

- :kite: Access app resources with one contextless unified syntax
- :dna: Null safe layer between Android framework and your app
- :heart: Kotlin powered, 100%.

```kotlin
class App : Application() {

    companion object {
        lateinit var appContext: Context
        val kite by lazy { Kite.fly(appContext) }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}
```

## Sample Usage

```kotlin
// Kite
fab.rippleColor =         kite.color[R.color.md_light_lime]
fab.backgroundTintList =  kite.colorStateList[R.color.md_lime]
fab.text =                kite.string[R.string.ride]

// Standard
fab.rippleColor =         ContextCompact.getColor(appContext, R.color.md_light_lime)
fab.backgroundTintList =  ColorStateList.valueOf(R.color.md_lime)
fab.text =                appContext.getString(R.string.ride)
```

## Supported Resources
| Resource Type   	| AAPT class 	| Namespace             	| Input                                                   	| Output              	| Implementation                      	| API 	| Variants           	|
|-----------------	|------------	|-----------------------	|---------------------------------------------------------	|---------------------	|-------------------------------------	|-----	|--------------------	|
| Strings         	| R.string   	| `Kite.string`         	| `@StringRes string: Int`                                	| `String`            	| `Context.getString()`               	| /   	| `formatArgs`       	|
| Plurals         	| R.plurals  	| `Kite.plural`         	| `@PluralRes plural: Int`, `quantity: Int`               	| `String`            	| `Resources.getQuantityString()`     	| /   	| `formatArgs`       	|
| Texts           	| R.string   	| `Kite.text`           	| `@StringRes text: Int`                                  	| `CharSequence`      	| `Context.getText()`                 	| /   	| /                  	|
| Color           	| R.color    	| `Kite.color`          	| `@ColorRes color: Int`                                  	| `@ColorInt Color`   	| `ContextCompat.getColor()`          	| /   	| /                  	|
| ColorStateLists 	| R.color    	| `Kite.colorStateList` 	| `@ColorRes colorStateList: Int`                         	| `ColorStateList`    	| `ContextCompat.getColorStateList()` 	| /   	| /                  	|
| Drawables       	| R.drawable 	| `Kite.drawable`       	| `@DrawableRes drawable: Int`                            	| `Drawable`          	| `ContextCompat.getDrawable()`       	| /   	| `Resources.Theme?` 	|
| Dimensions      	| R.dimen    	| `Kite.dimension`      	| `@DimenRes dimensions: Int`                             	| `Float`             	| `Resources.getDimensions()`         	| /   	| /                  	|
| Animations      	| R.anim     	| `Kite.animation`      	| `@AnimRes animation: Int`                               	| `Animation`         	| `AnimationUtils.loadAnimation()`    	| /   	| /                  	|
| Interpolators   	| R.anim     	| `Kite.interpolation`  	| `@InterpolatorRes interpolator: Int`                    	| `Interpolator`      	| `AnimationUtils.loadInterpolator()` 	| /   	| /                  	|
| Layouts         	| R.layout   	| `Kite.layout`         	| `@LayoutRes layout: Int`                                	| `XmlResourceParser` 	| `Resources.getlayout()`             	| /   	| /                  	|
| Booleans        	| R.bool     	| `Kite.booleans`       	| `@BoolRes bolean: Int`                                  	| `Boolean`           	| `Resources.getBoolean()`            	| /   	| /                  	|
| IntArray        	| R.array    	| `Kite.intArray`       	| `@ArrayRes intArray: Int`                               	| `IntArray`          	| `Resources.getIntArray()`           	| /   	| /                  	|
| StringArray     	| R.array    	| `Kite.stringArray`    	| `@ArrayRes stringArray: Int`                            	| `Array<out String>` 	| `Resources.getStringArray()`        	| /   	| /                  	|
| TypedArrays     	| R.array    	| `Kite.typedArray`     	| `@ArrayRes typedArray: Int`                             	| `TypedArray`        	| `Resources.obtainTypedArray()`      	| /   	| /                  	|
| Identifiers     	| R.id       	| `Kite.identifier`     	| `name: String`, `defType: String`, `defPackage: String` 	| `Int`               	| `Resources.getIdentifier()`         	| /   	| /                  	|
| Xmls            	| R.xml      	| `Kite.xml`            	| `@XmlRes xml: Int`                                      	| `XmlResourceParser` 	| `Resources.getXml()`                	| /   	| /                  	|
| Raws            	| R.raw      	| `Kite.raw`            	| `@RawRes raw: Int`                                      	| `InputStream`       	| `Resources.openRawResource()`       	| /   	| `TypedValue`       	|
| Fonts           	| R.font     	| `Kite.font`           	| `@FontRes font: Int`                                    	| `Typeface`          	| `Resources.getFont()`               	| 26  	| /                  	|
| Integer         	| R.integer  	| `Kite.integer`        	| `@IntegerRes integer: Int`                              	| `Int`               	| `Resources.getInteger()`            	| /   	| /                  	|
| Fraction        	| R.fraction 	| `Kite.fraction`       	| `@FractionRes fraction: Int`, `base: Int`, `pbase: Int` 	| `Float`             	| `Resources.getFraction()`           	| /   	| /                  	|

## Known Issues
- Annotation checks over resource parameters (functions which take as argument some annotated value, like `@ColorRes`, `@StringRes`) are not extensively performed by Android Studio, when using kotlin operator functions: I created a bug report to google issuetracker [here](https://issuetracker.google.com/issues/173628041).
