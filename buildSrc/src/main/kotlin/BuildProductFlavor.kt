import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.LibraryProductFlavor
import org.gradle.api.NamedDomainObjectContainer

/**
 * Created by Khomiak Ivan on 12,May,2022
 */

interface BuildProductFlavor {
    val name: String

    fun libraryCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
    ): LibraryProductFlavor

    fun appCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
    ): ApplicationProductFlavor
}

object ProductFlavorDevelop : BuildProductFlavor {
    override val name: String
        get() = "dev"

    override fun libraryCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
    ): LibraryProductFlavor {
        return namedDomainObjectContainer.create(name) {
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }

    override fun appCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
    ): ApplicationProductFlavor {
        return namedDomainObjectContainer.create(name) {
            versionNameSuffix = "-dev"
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }
}

object ProductFlavorStaging : BuildProductFlavor {
    override val name: String
        get() = "staging"

    override fun libraryCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
    ): LibraryProductFlavor {
        return namedDomainObjectContainer.create(name) {
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }

    override fun appCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
    ): ApplicationProductFlavor {
        return namedDomainObjectContainer.create(name) {
            versionNameSuffix = "-staging"
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }
}

object ProductFlavorProduction : BuildProductFlavor {
    override val name: String
        get() = "prod"

    override fun libraryCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
    ): LibraryProductFlavor {
        return namedDomainObjectContainer.create(name) {
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }

    override fun appCreate(
        namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
    ): ApplicationProductFlavor {
        return namedDomainObjectContainer.create(name) {
            versionNameSuffix = "-prod"
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }
}