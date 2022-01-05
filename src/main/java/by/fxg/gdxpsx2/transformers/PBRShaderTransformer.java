/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package by.fxg.gdxpsx2.transformers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;

import net.mgsx.gltf.scene3d.shaders.PBRShaderConfig;
import net.mgsx.gltf.scene3d.shaders.PBRShaderProvider;

/** 
 *  This <b>Post-processing</b> class using for render enhance. <br>
 *  {@link PBRShaderTransformer} is extension for the <b>gdx-gltf</b> library.
 *  @author fxgaming (FXG)
 */
public class PBRShaderTransformer extends ShaderTransformer {
	public PBRShaderTransformer() {
		super(Gdx.files.classpath("net/mgsx/gltf/shaders/gdx-pbr.vs.glsl"), Gdx.files.classpath("net/mgsx/gltf/shaders/gdx-pbr.fs.glsl"));
	}
	
	public ShaderProvider createShaderProvider(DefaultShader.Config config) {
		String vertexShader = this.injectVertexShader();
		String fragmentShader = this.fragmentShader;
		
		if (config != null && config instanceof PBRShaderConfig) {
			return PBRShaderProvider.createDefault((PBRShaderConfig)config);
		} else {
			PBRShaderConfig example = PBRShaderProvider.createDefaultConfig();
			example.vertexShader = vertexShader;
			example.fragmentShader = fragmentShader;
			return PBRShaderProvider.createDefault(example);
		}
	}
}
