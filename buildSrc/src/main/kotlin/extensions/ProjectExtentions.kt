package extensions

import org.gradle.api.Project
import utils.getLocalProperty

/**
 * Created by Khomiak Ivan on 17,May,2022
 */

/**
 * Obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getLocalProperty(propertyName: String): String {
    return getLocalProperty(propertyName, this)
}