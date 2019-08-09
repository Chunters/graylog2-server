/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog2.contentpacks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.graph.MutableGraph;
import org.graylog2.contentpacks.model.entities.EntityDescriptor;

public interface ContentPackable<T> {
    T toContentPackEntity(EntityDescriptorIds entityDescriptorIds);
    default void resolveNativeEntity(EntityDescriptor entityDescriptor,
                                     MutableGraph<EntityDescriptor> mutableGraph) {
    }

    @JsonIgnore
    default String getContentPackPluginPackage() {
        return this.getClass().getPackage().getName();
    }
}
