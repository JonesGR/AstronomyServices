import {AstType} from '../../ast_type/model/ast_type';

export interface CelestialBodyDetails {
  id: string;
  name: string;
  radius: number;
  astType: AstType;
}
