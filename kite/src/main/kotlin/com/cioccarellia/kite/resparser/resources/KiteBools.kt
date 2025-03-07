/**
 * Designed and developed by Andrea Cioccarelli (@cioccarellia)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package com.cioccarellia.kite.resparser.resources

import androidx.annotation.BoolRes
import androidx.annotation.IntRange
import com.cioccarellia.kite.resparser.KiteResParser

/**
 * KiteBools Implementation
 * */
class KiteBools : KiteResParser<@BoolRes Int, Boolean>() {
    override operator fun get(
        @BoolRes @IntRange(from = 1) boolean: Int
    ): Boolean = kiteContext.resources.getBoolean(boolean)
}